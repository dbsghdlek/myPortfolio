package com.example.portfolio.redis;

import com.example.portfolio.config.redis.RefreshToken;
import com.example.portfolio.config.redis.RefreshTokenRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Redis CRUD Test")
public class RedisTest {

    @Autowired
    private RefreshTokenRepository repository;

    @BeforeEach
    public void setData(){
        RefreshToken token = RefreshToken.builder()
                .token("test")
                .ttl(20241130L)
                .role("test")
                .authId("test")
                .build();

        repository.save(token);
    }


    @Test
    @DisplayName("Redis search 테스트")
    public void getTest(){
        RefreshToken test = repository.findByAuthId("test").orElseThrow();
        System.out.println("test.getAuthId() = " + test.getAuthId());
        System.out.println("test.getRole() = " + test.getRole());
        System.out.println("test.getTtl() = " + test.getTtl());
        System.out.println("test.getToken() = " + test.getToken());
        Assertions.assertThat(test.getAuthId()).isEqualTo("test");
    }
}
