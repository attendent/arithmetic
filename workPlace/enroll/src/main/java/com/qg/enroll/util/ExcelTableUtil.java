/*
package com.qg.enroll.util;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;
import com.qg.enroll.model.Student;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * @author net
 * @version 1.0
 * excel表格处理工具；
 *//*

public class ExcelTableUtil {
    */
/**
     * 创建奖项EXCEL表格
     *
     * @param awardInfos 奖项列表
     * @return 该文件的路径；
     *//*
*/
/*
    public static String createAwardExcel(List<AwardInfo> awardInfos) throws IOException {
        //记录路径
        String path;
        try (OutputStream out = new FileOutputStream("奖项.xls")) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLS);
            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("sheet1");
            List<List<String>> data = new ArrayList<>();
            //列表不为空才创建迭代进行遍历创建excel文件；
            if (!awardInfos.isEmpty()) {
                Iterator<AwardInfo> iterator = awardInfos.iterator();
                while (iterator.hasNext()) {
                    List<String> list = new ArrayList<>();
                    AwardInfo awardInfo1 = iterator.next();
                    list.add(awardInfo1.getAwardName());
                    list.add(awardInfo1.getAwardTime());
                    list.add(awardInfo1.getAwardLevel());
                    list.add(awardInfo1.getRank());
                    list.add(awardInfo1.getDepartment());
                    list.add(awardInfo1.getLeadTeacher());
                    list.add(awardInfo1.getJoinStudent());
                    list.add(awardInfo1.getAwardDescription());
                    list.add(awardInfo1.getAwardProject());
                    data.add(list);
                }
                List<List<String>> head = new ArrayList<>();
                List<String> headCoulumn1 = new ArrayList<>();
                List<String> headCoulumn2 = new ArrayList<>();
                List<String> headCoulumn3 = new ArrayList<>();
                List<String> headCoulumn4 = new ArrayList<>();
                List<String> headCoulumn5 = new ArrayList<>();
                List<String> headCoulumn6 = new ArrayList<>();
                List<String> headCoulumn7 = new ArrayList<>();
                List<String> headCoulumn8 = new ArrayList<>();
                List<String> headCoulumn9 = new ArrayList<>();
                headCoulumn1.add(AwardHead.AWARD_NAME.getAwardHead());
                headCoulumn2.add(AwardHead.AWARD_GET_TIME.getAwardHead());
                headCoulumn3.add(AwardHead.AWARD_LEVEL.getAwardHead());
                headCoulumn4.add(AwardHead.AWARD_RANK.getAwardHead());
                headCoulumn5.add(AwardHead.AWARD_DEPARTMENT.getAwardHead());
                headCoulumn6.add(AwardHead.LEAD_TEACHER.getAwardHead());
                headCoulumn7.add(AwardHead.JOIN_STUDENT.getAwardHead());
                headCoulumn8.add(AwardHead.AWARD_DESCRIPTION.getAwardHead());
                headCoulumn9.add(AwardHead.AWARD_PROJECT.getAwardHead());
                head.add(headCoulumn1);
                head.add(headCoulumn2);
                head.add(headCoulumn3);
                head.add(headCoulumn4);
                head.add(headCoulumn5);
                head.add(headCoulumn6);
                head.add(headCoulumn7);
                head.add(headCoulumn8);
                head.add(headCoulumn9);
                Table table = new Table(1);
                table.setHead(head);
                writer.write0(data, sheet1, table);
                writer.finish();
            }
        }
        File file = new File("奖项.xls");
        path = file.getAbsolutePath();
        return path;
    }

    *//*
*/
/**
     * 创建用户信息EXCEL表格
     *
     * @param userInfoList 成员信息表格
     * @return 该文件的路径；
     *//*
*/
/*
    public static String createUserExcel(List<UserInfo> userInfoList) throws IOException {
        String path;
        try (OutputStream out = new FileOutputStream("成员信息.xls")) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLS);
            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("sheet1");
            List<List<String>> data = new ArrayList<>();
            //列表不为空才创建迭代进行遍历创建excel文件；
            if (!userInfoList.isEmpty()) {
                Iterator<UserInfo> iterator = userInfoList.iterator();
                while (iterator.hasNext()) {
                    List<String> list = new ArrayList<>();
                    UserInfo userInfo = iterator.next();
                    list.add(userInfo.getName());
                    list.add(userInfo.getGroup());
                    list.add(userInfo.getCollege());
                    list.add(userInfo.getGrade());
                    list.add(userInfo.getTel());
                    list.add(userInfo.getBirthplace());
                    list.add(userInfo.getQq());
                    list.add(userInfo.getEmail());
                    list.add(userInfo.getDescription());
                    data.add(list);
                }
                List<List<String>> head = new ArrayList<>();
                List<String> headCoulumn1 = new ArrayList<>();
                List<String> headCoulumn2 = new ArrayList<>();
                List<String> headCoulumn3 = new ArrayList<>();
                List<String> headCoulumn4 = new ArrayList<>();
                List<String> headCoulumn5 = new ArrayList<>();
                List<String> headCoulumn6 = new ArrayList<>();
                List<String> headCoulumn7 = new ArrayList<>();
                List<String> headCoulumn8 = new ArrayList<>();
                List<String> headCoulumn9 = new ArrayList<>();
                headCoulumn1.add(UserInfoHead.USERNAME.getUserInfoHead());
                headCoulumn2.add(UserInfoHead.USER_GROUP.getUserInfoHead());
                headCoulumn3.add(UserInfoHead.COLLEGE.getUserInfoHead());
                headCoulumn4.add(UserInfoHead.STUDENT_NUMBER.getUserInfoHead());
                headCoulumn5.add(UserInfoHead.TELEPHONE.getUserInfoHead());
                headCoulumn6.add(UserInfoHead.BIRTHPLACE.getUserInfoHead());
                headCoulumn7.add(UserInfoHead.QQ.getUserInfoHead());
                headCoulumn8.add(UserInfoHead.EMAIL.getUserInfoHead());
                headCoulumn9.add(UserInfoHead.DESCRIPTION.getUserInfoHead());
                head.add(headCoulumn1);
                head.add(headCoulumn2);
                head.add(headCoulumn3);
                head.add(headCoulumn4);
                head.add(headCoulumn5);
                head.add(headCoulumn6);
                head.add(headCoulumn7);
                head.add(headCoulumn8);
                head.add(headCoulumn9);
                Table table = new Table(1);
                table.setHead(head);
                writer.write0(data, sheet1, table);
                writer.finish();
            }
        }
        File file = new File("成员信息.xls");
        path = file.getAbsolutePath();
        return path;
    }
*//*

    */
/**
     * 读取excel
     *
     * @param filePath 文件路径
     * @return 成员信息列表
     *//*

    public static List<Student> readResultExcel(String filePath) {
        final List<Student> students = new ArrayList<>();
        try {
            try (InputStream in = new FileInputStream(filePath)) {
                AnalysisEventListener<List<String>> listener = new AnalysisEventListener<List<String>>() {
                    @Override
                    public void invoke(List<String> object, AnalysisContext context) {
                        System.out.println("Row:" + context.getCurrentRowNum() + " Data:" + object);
                        //读取第一行真实数据；
                        if (context.getCurrentRowNum() > 0) {
                            Student student = new Student();
                            if (object.size() >= 1) {
                                student.setId(object.get(0));
                            }
                            if (object.size() >= 2) {
                                student.setCurrent(Integer.valueOf(object.get(1)));
                            }
                            students.add(student);
                        }
                    }
                    @Override
                    public void doAfterAllAnalysed(AnalysisContext context) {
                        System.err.println("doAfterAllAnalysed...");
                    }
                };
                ExcelReader excelReader = null;
                try {
                    excelReader = ExcelReaderFactory.getExcelReader(in, null, listener);
                } catch (InvalidFormatException e) {
                    System.out.println("文件格式无效，读取失败。");
                }
                if (excelReader != null) {
                    excelReader.read();
                }
                return students;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;

    }

}
*/
