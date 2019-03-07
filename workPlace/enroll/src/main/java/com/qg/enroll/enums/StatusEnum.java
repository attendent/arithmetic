package com.qg.enroll.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusEnum {

    /**
     * 操作成功
     */
    SUCCESS("2001"),

    /**
     * 修改成功
     */
    UPDATE_SUCCESS("2002"),

    /**
     * 学号错误
     */
    STUDENT_ID_ERROR("4002"),

    /**
     * 手机号错误
     */
    STUDENG_TEL_ERROR("4003"),

    /**
     * 未登录
     */
    LOGIN_ERROE("4005"),

    /**
     * 参数错误
     */
    PARAMENTER_ERROR("4004"),

    /**
     * 访问过快
     */
    SERVER_TOO_FAST("4006"),

    /**
     * 服务器错误
     */
    SERVER_HAPPEN_ERROR("5000");




    private String status;

    public String getStatus() {
        return status;
    }
}
