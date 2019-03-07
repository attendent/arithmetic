package com.qg.enroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ServletComponentScan
public class EnrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnrollApplication.class, args);
    }

}
