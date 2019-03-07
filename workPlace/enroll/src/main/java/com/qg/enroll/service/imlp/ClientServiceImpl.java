package com.qg.enroll.service.imlp;

import com.qg.enroll.dao.ClientDao;
import com.qg.enroll.dtos.Data;
import com.qg.enroll.dtos.RequestData;
import com.qg.enroll.dtos.ResponseData;
import com.qg.enroll.enums.StatusEnum;
import com.qg.enroll.model.Student;
import com.qg.enroll.service.ClientService;
import com.qg.enroll.util.FormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    @Resource
    private ClientDao clientDao;

    @Resource
    private ResponseData responseData;

    /**
     * 查看面试时间地点
     *
     * @param httpSession 用户信息
     * @return 时间地点
     */
    @Cacheable(value = "timeAndPlace", key = "#httpSession.getAttribute(\"student\").id")
    @Override
    public ResponseData getTimeAndPlace(HttpSession httpSession) {
        Student student = (Student) httpSession.getAttribute("student");
        log.info("查看面试时间地点-->用户{}查看", student.getId());

        student = clientDao.getStudentInfoById(student.getId());

        log.info("查看面试时间地点-->用户信息：{}", student);
        String word = getWord(student);
        responseData.setStatus(StatusEnum.SUCCESS.getStatus());

        Data data = new Data();
        data.setStudent(student);
        data.setWord(word);
        responseData.setData(data);
        return responseData;
    }

    /**
     * 登录
     *
     * @param requestData 学号 + 手机号
     * @param httpSession 用户信息
     * @return 面试地点、时间
     */
    @Cacheable("student")
    @Override
    public ResponseData login(RequestData<Student> requestData, HttpSession httpSession) {
        Student student = requestData.getStudent();
        if (null != student) {
            String id = student.getId();
            String tel = student.getTel();
            log.info("用户登录-->学号:{}, 手机号:{}", id, tel);

            if (FormatUtil.checkId(id) && FormatUtil.isPhoneLegal(tel)) {
                // 判断学号、手机号
                student = clientDao.getStudentByIdAndTel(id, tel);
                if (FormatUtil.checkNull(student)) {
                    log.info("用户登录-->学号{}登录成功", id);
                    httpSession.setAttribute("student", student);
                    responseData.setStatus(StatusEnum.SUCCESS.getStatus());
                } else {
                    // 判断学号是否存在
                    student = clientDao.getStudentById(id);
                    if (FormatUtil.checkNull(student)) {
                        log.info("用户登录-->学号{}输错电话号码:{}", id, tel);
                        responseData.setStatus(StatusEnum.STUDENG_TEL_ERROR.getStatus());
                    } else {
                        log.info("用户登录-->学号{}不存在", id);
                        responseData.setStatus(StatusEnum.STUDENT_ID_ERROR.getStatus());
                    }
                }
            } else {
                log.info("用户登录-->参数错误2-->错误tel或id");
                responseData.setStatus(StatusEnum.PARAMENTER_ERROR.getStatus());
            }
        } else {
            log.info("用户登录-->参数错误-->无student");
            responseData.setStatus(StatusEnum.PARAMENTER_ERROR.getStatus());
        }

        return responseData;
    }

    /**
     * 学生反馈情况
     *
     * @param httpSession 用户信息
     * @return 状态码
     */
    @Override
    public ResponseData addFeedback(HttpSession httpSession) {
        Student student = (Student) httpSession.getAttribute("student");
        student = clientDao.getStudentCurrentById(student.getId());
        log.info("学生反馈情况-->{}", student);

        clientDao.updateStudentReplyById(student.getId(), student.getCurrent());
        log.info("学生反馈情况-->反馈成功");

        responseData.setStatus(StatusEnum.SUCCESS.getStatus());
        return responseData;
    }

    /**
     * 编辑文案
     *
     * @param student 学生信息
     * @return 文案
     */
    private String getWord(Student student) {
        String name = student.getName();
        int current = student.getCurrent();
        String grouper = student.getGrouper();

        String sex = student.getSex().equals("男") ? "师弟" : "师妹";
        String word = "";
        String nowPart;
        String nextPart;

        switch (current) {
            case 0: {
                word = "亲爱的" + name + sex + "。" + "\n"
                        + "欢迎参加2019级QG考核!" + "\n"
                        + "目前仍未有一面消息，请耐心等待~";
                break;
            }
            case 1: {
                nowPart = "笔试";
                nextPart = "第一次面试";
                word = getSuccessWord(name, sex, current, nowPart, nextPart, grouper);
                break;
            }
            case -1: {
                nowPart = "笔试";
                word = getFailWord(name, sex, nowPart, grouper);
                break;
            }
            case 2: {
                nowPart = "第一次面试";
                nextPart = "第二次面试";
                word = getSuccessWord(name, sex, current, nowPart, nextPart, grouper);
                break;
            }
            case -2: {
                nowPart = "第一次面试";
                word = getFailWord(name, sex, nowPart, grouper);
                break;
            }
            case 3: {
                word = "亲爱的" + name + sex + "。" + "\n"
                        + "恭喜你通过2019级QG二面!并进入QG训练营" + "\n"
                        + "请及时添加你们师兄的QQ1213018820" + "\n";
                break;
            }
            case -3: {
                nowPart = "第二次面试";
                word = getFailWord(name, sex, nowPart, grouper);
                break;
            }
        }
        return word;
    }

    private String getTimeAndPlace(int position, String grouper) {
        String timeAndPlace = clientDao.getTimeAndPlace(position, grouper);
        String[] strings = timeAndPlace.split("#");
        timeAndPlace = "";
        for (String str : strings) {
            timeAndPlace += str;
        }

        log.info("得到时间地点getTimeAndPlace-->{}", timeAndPlace);
        return timeAndPlace;
    }

    private String getSuccessWord(String name, String sex, int current, String nowPart, String nextPart, String grouper) {
        String timeAndPlace = getTimeAndPlace(current, grouper);

        if (!FormatUtil.checkNull(timeAndPlace)) {
            return "【QG工作室】" + name + sex + "你好，" + "\n"
                    + "恭喜你通过2019级QG" + grouper + nowPart + "!\n"
                    + nextPart + "时间仍未公布，请耐心等待" + "\n";
        }
        if (nowPart.equals("第二次面试")) {
            return "【QG工作室】" + name + sex + "你好，" + "\n"
                    + "恭喜你通过2019级QG" + grouper + nowPart + "!\n"
                    + "以下是" + nextPart + "时间，请留意：" + "\n"
                    + timeAndPlace + "\n"
                    + "如果有自己的小作品，可以带过来参加二面。";
        }
        return "【QG工作室】" + name + sex + "你好，" + "\n"
                + "恭喜你通过2019级QG" + grouper + nowPart + "!\n"
                + "以下是" + nextPart + "时间，请留意：" + "\n"
                + timeAndPlace;
    }

    private String getFailWord(String name, String sex, String nowPart, String grouper) {
        return "【QG工作室】" + name + sex + "你好,十分感谢你能参加我们QG工作室的考核" + "\n"
                + "但是很遗憾，这次你没能通过我们的" + grouper + nowPart + "\n"
                + "尽管你已经表现得足够优秀，但我们的招新人数毕竟有限。希望你的编程之路能不止于此，加油！";
    }
}
