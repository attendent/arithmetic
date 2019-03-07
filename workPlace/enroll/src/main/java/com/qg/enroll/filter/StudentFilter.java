package com.qg.enroll.filter;

import com.google.gson.Gson;
import com.qg.enroll.dtos.ResponseData;
import com.qg.enroll.enums.StatusEnum;
import com.qg.enroll.model.Student;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "studentFilter", urlPatterns = {"/client/*"})
public class StudentFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("用户查看过滤器-->>初始化");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("权限过滤器-->>开始过滤");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String url = httpServletRequest.getRequestURI();
        Student student = (Student) httpServletRequest.getSession().getAttribute("student");

        log.info("权限过滤器-->正在访问{}", url);
        if (null != student || url.equals("/client/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return ;
        }

        ResponseData responseData = new ResponseData();
        responseData.setStatus(StatusEnum.LOGIN_ERROE.getStatus());
        httpServletResponse.getWriter().write(new Gson().toJson(responseData));
    }

    @Override
    public void destroy() {

    }
}
