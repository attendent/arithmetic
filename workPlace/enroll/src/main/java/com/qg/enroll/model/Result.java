package com.qg.enroll.model;

/**
 * 考核结果
 */
public class Result {
    /**
     * 学生Id
     */
    String studentId;

    /**
     * 考核轮次
     */
    int position;

    /**
     * 考核结果
     * 1:通过
     * 0:不通过
     */
    int result;
}
