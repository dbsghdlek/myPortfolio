package com.example.portfolio.redis;

import com.example.portfolio.config.redis.RefreshToken;
import com.example.portfolio.config.redis.RefreshTokenRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Redis CRUD Test")
public class RedisTest {

    @Autowired
    private RefreshTokenRepository repository;

    @BeforeEach
    public void setData(){
        RefreshToken token = RefreshToken.builder()
                .token("test")
                .ttl(10L)
                .role("test")
                .authId("test")
                .build();

        RefreshToken token1 = RefreshToken.builder()
                .token("test2")
                .ttl(10L)
                .role("test2")
                .authId("test2")
                .build();

        repository.save(token);

        try {
            Thread.sleep(5000);
            repository.save(token1);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

//    @AfterEach
//    public void deleteData(){
//        repository.deleteById("test");
//    }


    @Test
    @DisplayName("Redis search 테스트")
    public void getTest(){
        Optional<RefreshToken> test = repository.findByAuthId("test");
        Assertions.assertThat(test.isEmpty()).isEqualTo(true);
    }
}
