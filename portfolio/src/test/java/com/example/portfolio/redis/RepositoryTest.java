package com.example.portfolio.redis;

import com.example.portfolio.config.QueryDslConfig;
import com.example.portfolio.config.RedisConfig;
import com.example.portfolio.config.redis.RefreshToken;
import com.example.portfolio.config.redis.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

@Import(RedisConfig.class)
public class RepositoryTest {

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
    public void getTest(){
        RefreshToken test = repository.findByAuthId("test").orElseThrow();
        Assertions.assertThat(test).isEqualTo("test");
    }
}
