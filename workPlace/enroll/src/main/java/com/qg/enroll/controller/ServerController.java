package com.qg.enroll.controller;

import com.qg.enroll.dtos.RequestData;
import com.qg.enroll.dtos.ResponseData;
import com.qg.enroll.model.Feedback;
import com.qg.enroll.model.Inform;
import com.qg.enroll.model.Student;
import com.qg.enroll.service.ClientService;
import com.qg.enroll.service.ServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/server")
public class ServerController {
    @Resource
    private ServerService serverService;

    @PostMapping("/addinform")
    public ResponseData addInform(@RequestBody RequestData<Inform> requestData) {
        return serverService.addTimeAndPlace(requestData);
    }

    @PostMapping("/addresult")
    public ResponseData addResult(@RequestParam("file") MultipartFile file) {
        return serverService.addResult(file);
    }

    @PostMapping("/listfeedback")
    public ResponseData listFeedback(@RequestBody RequestData<Student> requestData) {
        return serverService.listFeedback(requestData);
    }
}
