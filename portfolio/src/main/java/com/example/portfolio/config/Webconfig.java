package com.example.portfolio.config;

import com.example.portfolio.config.interceptor.MyInterCeptor;
import com.example.portfolio.domain.music.service.MusicInfoProvider;
import com.example.portfolio.domain.music.service.provider.MusicInfoRestProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class Webconfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterCeptor())
                .order(1)
                .addPathPatterns("/**");
    }

    @Bean
    public MusicInfoProvider musicInfoProvider(){
        return new MusicInfoRestProvider();
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
