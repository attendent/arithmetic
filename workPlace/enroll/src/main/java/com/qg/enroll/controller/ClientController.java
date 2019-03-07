package com.qg.enroll.controller;

import com.qg.enroll.dtos.RequestData;
import com.qg.enroll.dtos.ResponseData;
import com.qg.enroll.model.Feedback;
import com.qg.enroll.model.Student;
import com.qg.enroll.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/client")
public class ClientController {
    @Resource
    private ClientService clientService;

    @PostMapping("/login")
    public ResponseData login(@RequestBody RequestData<Student> requestData, HttpSession httpSession) {
        return clientService.login(requestData, httpSession);
    }

    @PostMapping("/listinform")
    public ResponseData listInform(HttpSession httpSession) {
        return clientService.getTimeAndPlace(httpSession);
    }


    @PostMapping("/addfeedback")
    public ResponseData addFeedback(HttpSession httpSession) {
        return clientService.addFeedback(httpSession);
    }
}
