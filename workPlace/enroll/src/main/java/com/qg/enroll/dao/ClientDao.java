package com.qg.enroll.dao;

import com.qg.enroll.model.Feedback;
import com.qg.enroll.model.Inform;
import com.qg.enroll.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户端dao层
 * @author HC
 */
@Mapper
public interface ClientDao {
    /**
     * 查看面试时间地点
     * @param position 某个环节
     * @return 时间地点
     */
    String getTimeAndPlace(@Param("position") int position, @Param("grouper") String grouper);

    /**
     * 根据学号查询具体学生信息
     * @param id 学号
     * @return 学生信息
     */
    Student getStudentInfoById(String id);

    /**
     * 根据学号查询学生信息
     * @param id 学号
     * @return 学生信息
     */
    Student getStudentById(String id);

    /**
     * 根据学号查询学生当前轮次
     * @param id 学号
     * @return 学生信息
     */
    Student getStudentCurrentById(String id);

    /**
     * 根据学号跟手机号查询学生信息
     * @param id 学号
     * @param tel 手机号
     * @return 学生信息
     */
    Student getStudentByIdAndTel(@Param("id") String id, @Param("tel") String tel);

    /**
     * 保存学生反馈信息
     * @param feedback 反馈信息
     * @return 保存成功条数
     */
    int saveFeedback(Feedback feedback);

    int updateStudentReplyById(@Param("id") String id, @Param("reply") int reply);

}
