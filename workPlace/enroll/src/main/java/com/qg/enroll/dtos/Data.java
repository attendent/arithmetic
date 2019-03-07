package com.qg.enroll.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.qg.enroll.model.Feedback;
import com.qg.enroll.model.Student;

import java.io.Serializable;
import java.util.List;

/**
 * @author Chen
 * time 2018-10-03 15:42:20
 * description 用来承载所需响应给前端的数据
 */
@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data implements Serializable {

    /**
     * 学生信息
     */
    Student student;

    /**
     * 文案
     */
    String word;

    List<Student> studentList;

    List<Feedback> feedbackList;
}
