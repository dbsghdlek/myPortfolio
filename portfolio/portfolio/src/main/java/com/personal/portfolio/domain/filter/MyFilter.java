package com.personal.portfolio.domain.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filter info");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest HttpRequest = (HttpServletRequest) request;
        String requestURI = HttpRequest.getRequestURI();
        log.info("REQUEST [{}][{}]",requestURI, request.getDispatcherType());
    }

    @Override
    public void destroy() {
        log.info("Log Filter Destroy");
    }
}
