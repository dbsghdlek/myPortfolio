package com.personal.portfolio.domain.config;

import com.personal.portfolio.domain.filter.MyFilter;
import com.personal.portfolio.domain.interceptor.MyInterCeptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

@Configuration
public class Webconfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterCeptor())
                .order(1)
                .addPathPatterns("/**");
    }

    /* @Bean
     public FilterRegistrationBean addMyFilter(){
         FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
         filterRegistrationBean.setFilter(new MyFilter());
         filterRegistrationBean.setOrder(1);
         filterRegistrationBean.addUrlPatterns("/*");
         filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST,DispatcherType.ERROR);
         return filterRegistrationBean;
     }*/
}
