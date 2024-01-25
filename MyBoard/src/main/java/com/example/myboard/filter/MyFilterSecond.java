package com.example.myboard.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;

@Slf4j
public class MyFilterSecond implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.info("filterChain init2");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uuid = UUID.randomUUID().toString();
        try {
            log.info("Request(MyFilterSecond) [{}] [{}]",uuid,httpRequest.getRequestURI());
            // 다음 필터 호출!
            chain.doFilter(request,response);
        } catch (Exception e) {
            throw e;
        } finally {
            log.info("Response(MyFilterSecond) [{}] [{}]",uuid,httpRequest.getRequestURI());
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        log.info("filter destroy2");
    }
}
