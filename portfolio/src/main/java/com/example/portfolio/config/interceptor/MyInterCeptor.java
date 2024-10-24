package com.example.portfolio.config.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
public class MyInterCeptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("REQUEST PreHandle [{}, {}]", (String)request.getRequestURI(), request.getDispatcherType());

        long currentTime = System.currentTimeMillis();
        
        //현재시간을 모델에 입력
        request.setAttribute("bTime", currentTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
           log.info("PostHandle [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long currentTime = System.currentTimeMillis();
        long beginTime = (long) request.getAttribute("bTime");
        
        //경과 시간 계산
        long processedTime = currentTime - beginTime;

        log.info("After Completion!!");
        log.info(new StringBuilder("process Time : ").append(processedTime).toString());
    }
}
