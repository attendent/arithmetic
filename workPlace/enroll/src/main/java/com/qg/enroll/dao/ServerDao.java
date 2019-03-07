package com.qg.enroll.dao;

import com.qg.enroll.model.Feedback;
import com.qg.enroll.model.Inform;
import com.qg.enroll.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;

/**
 * 服务端dao层
 * @author HC
 */
@Mapper
public interface ServerDao {

    /**
     * 保存时间地点
     * @param inform 学号 + 时间地点
     * @return 保存成功条数
     */
    Integer saveTimeAndPlace(Inform inform);

    /**
     * 保存结果
     * @param students 学号 + 结果
     * @return 更新成功条数
     */
    Integer updateStudentCurrents(@Param("students") List<Student> students);

    /**
     * 查询反馈信息
     * @param student 组别/轮次
     * @return 反馈结果列表
     */
    List<Student> listFeedback(Student student);
}
