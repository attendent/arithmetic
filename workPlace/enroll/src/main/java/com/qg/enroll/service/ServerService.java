package com.qg.enroll.service;

import com.qg.enroll.dtos.RequestData;
import com.qg.enroll.dtos.ResponseData;
import com.qg.enroll.model.Feedback;
import com.qg.enroll.model.Inform;
import com.qg.enroll.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Service
public interface ServerService {
    /**
     * 设置面试时间地点
     * @param requestData 轮次 + 时间地点
     * @return 时间地点
     */
    ResponseData addTimeAndPlace(RequestData<Inform> requestData);

    /**
     * 添加结果
     * @param file 文件
     * @return 面试地点、时间
     */
    ResponseData addResult(MultipartFile file);

    /**
     * 查看学生反馈情况
     * @param requestData 组别和轮次
     * @return 状态码
     */
    ResponseData listFeedback(RequestData<Student> requestData);
}
