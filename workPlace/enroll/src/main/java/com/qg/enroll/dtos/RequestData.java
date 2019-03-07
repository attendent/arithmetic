package com.qg.enroll.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.qg.enroll.model.Feedback;
import com.qg.enroll.model.Inform;
import com.qg.enroll.model.Student;
import lombok.Data;

import java.util.List;

/**
 * @author Chen
 * time 2018-10-02 17:26:30
 * description 向数据挖掘发送请求的类
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestData<T> {

    /**
     * 各类信息
     */
    T data;

    Student student;

    Feedback feedback;

    Inform inform;

    /**
     * 列表
     */
    List<T> list;

    /**
     * 用电量
     */
    Double[] powerSums;
}
