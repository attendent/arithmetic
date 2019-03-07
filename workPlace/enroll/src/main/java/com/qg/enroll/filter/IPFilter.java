package com.qg.enroll.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.google.gson.Gson;
import com.qg.enroll.dtos.ResponseData;
import com.qg.enroll.enums.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "ipFilter", urlPatterns = {"/*"})
public class IPFilter implements Filter {

    static RateLimiter limiter = RateLimiter.create(10);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (limiter.tryAcquire()) {
            log.info("限流过滤器-->请求放行");
            chain.doFilter(request, response);
        } else {
            log.warn("限流过滤器-->流量过多");
            ResponseData responseData = new ResponseData();
            responseData.setStatus(StatusEnum.SERVER_TOO_FAST.getStatus());
            response.getWriter().write(new Gson().toJson(responseData));
        }

    }

    @Override
    public void destroy() {

    }
}