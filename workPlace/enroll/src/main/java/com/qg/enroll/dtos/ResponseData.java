package com.qg.enroll.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author Chen
 * time 2018-10-03 15:42:20
 * description 响应前端的类
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Service
@Scope("prototype")
public class ResponseData implements Serializable {
    /**
     * 响应状态码
     */
    String status;

    /**
     * 数据
     */
    Data data;
}
