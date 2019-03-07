package com.qg.enroll.service.imlp;

import com.qg.enroll.dao.ServerDao;
import com.qg.enroll.dtos.Data;
import com.qg.enroll.dtos.RequestData;
import com.qg.enroll.dtos.ResponseData;
import com.qg.enroll.enums.StatusEnum;
import com.qg.enroll.model.Feedback;
import com.qg.enroll.model.Inform;
import com.qg.enroll.model.Student;
import com.qg.enroll.service.ServerService;
import com.qg.enroll.util.ExcelUtil;
import com.qg.enroll.util.FormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class ServerServiceImpl implements ServerService {
    @Resource
    private ResponseData responseData;
    @Resource
    private ServerDao serverDao;


    /**
     * 设置面试时间地点
     *
     * @param requestData 轮次 + 时间地点
     * @return 时间地点
     */
    @CachePut("timeAndPlace")
    @Override
    public ResponseData addTimeAndPlace(RequestData<Inform> requestData) {
        Inform inform = requestData.getInform();
        if (FormatUtil.checkNull(inform)) {
            log.info("设置面试时间地点-->{}", inform);
            int position = inform.getPosition();
            String timeAndPlace = inform.getTimeAndPlace();
            if(position > 0 && position < 4 && FormatUtil.isTimeAndPlace(timeAndPlace) && FormatUtil.checkGrouper(inform.getGrouper())) {
                log.info("设置{}面试时间地点{}-->设定成功", inform.getPosition(), inform.getTimeAndPlace());
                serverDao.saveTimeAndPlace(inform);
                responseData.setStatus(StatusEnum.SUCCESS.getStatus());
                return responseData;
            }
        }
        log.warn("设置面试时间地点-->参数错误");
        responseData.setStatus(StatusEnum.PARAMENTER_ERROR.getStatus());
        return responseData;
    }

    /**
     * 添加结果
     *
     * @param file     文件
     * @return 面试地点、时间
     */
    @Override
    public ResponseData addResult(MultipartFile file) {
        if (!file.isEmpty()) {
            File dir = new File("/usr/local");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //存储文件
            File storeFile = new File(dir.getAbsolutePath() + File.separator + file.getName() + ".xlsx");
            try {
                file.transferTo(storeFile);
            } catch (IOException e) {
                responseData.setStatus(StatusEnum.SERVER_HAPPEN_ERROR.getStatus());
                return responseData;
            }
            // 获取文件中的结果；
            List<Student> students = ExcelUtil.readExcel(file, new Student());
            assert students != null;
            if (!students.isEmpty()) {
                log.info("添加结果-->导入成功");
                System.out.println(students);
                serverDao.updateStudentCurrents(students);
                responseData.setStatus(StatusEnum.SUCCESS.getStatus());
            } else {
                log.info("添加结果-->文件中无内容");
                responseData.setStatus(StatusEnum.PARAMENTER_ERROR.getStatus());
            }

            //TODO 加判断
        } else {
            //由于文件数据的缺失
            log.info("添加结果-->文件数据的缺失");
            responseData.setStatus(StatusEnum.PARAMENTER_ERROR.getStatus());
        }
        return responseData;
    }

    /**
     * 查看学生反馈情况
     *
     * @param requestData 组别和轮次
     * @return 状态码
     */
    @Override
    public ResponseData listFeedback(RequestData<Student> requestData) {
        Student student = requestData.getStudent();
        if (FormatUtil.checkNull(student)) {
            String grouper = student.getGrouper();
            if (null == grouper || FormatUtil.checkGrouper(grouper)) {
                log.info("查看学生反馈情况-->查看成功");
                List<Student> studentList = serverDao.listFeedback(student);
                log.info("查看学生反馈情况-->{}", studentList);
                responseData.setStatus(StatusEnum.SUCCESS.getStatus());
                Data data = new Data();
                data.setStudentList(studentList);
                responseData.setData(data);
                return responseData;
            }
        }
        responseData.setStatus(StatusEnum.PARAMENTER_ERROR.getStatus());
        return responseData;
    }
}
