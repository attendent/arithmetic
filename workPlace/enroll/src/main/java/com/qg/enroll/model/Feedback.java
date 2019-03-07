package com.qg.enroll.model;

import lombok.Data;

@Data
public class Feedback {

    /**
     * 学号
     */
    String id;

    /**
     * 轮次
     */
    int position;

    /**
     * 学生姓名
     */
    String name;

    /**
     * 手机号码
     */
    String tel;

    /**
     * 组别
     */
    String grouper;

    /**
     * 反馈消息
     */
    String note;
}
