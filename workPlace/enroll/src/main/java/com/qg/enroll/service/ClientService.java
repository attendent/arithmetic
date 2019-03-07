package com.qg.enroll.service;

import com.qg.enroll.dtos.RequestData;
import com.qg.enroll.dtos.ResponseData;
import com.qg.enroll.model.Feedback;
import com.qg.enroll.model.Student;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface ClientService {
    /**
     * 查看面试时间地点
     * @param httpSession 用户信息
     * @return 时间地点
     */
    ResponseData getTimeAndPlace(HttpSession httpSession);

    /**
     * 登录
     * @param requestData 学号 + 手机号
     * @param httpSession 用户信息
     * @return 面试地点、时间
     */
    ResponseData login(RequestData<Student> requestData, HttpSession httpSession);

    /**
     * 学生反馈情况
     * @param httpSession 用户信息
     * @return 状态码
     */
    ResponseData addFeedback(HttpSession httpSession);
}
