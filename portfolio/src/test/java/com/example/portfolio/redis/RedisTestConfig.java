package com.example.portfolio.redis;

import com.example.portfolio.domain.redis.RedisUtils;
import lombok.RequiredArgsConstructor;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@TestConfiguration
@RequiredArgsConstructor
public class RedisTestConfig {
    private final RestTemplate restTemplate;
    @Bean
    private final RedisUtils redisUtils(){
        return Mockito.mock(RedisUtils.class);
    }
}
