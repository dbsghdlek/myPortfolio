package com.example.portfolio.redis;

import com.example.portfolio.domain.redis.RedisUtils;
import com.example.portfolio.domain.redis.RefreshToken;
import com.example.portfolio.domain.redis.RefreshTokenRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Redis CRUD Test")
public class RedisTest {

    @Autowired
    private RefreshTokenRepository repository;

    @Autowired
    private RedisUtils redisUtils;

    @BeforeEach
    public void setData(){
//        RefreshToken token = RefreshToken.builder()
//                .token("test")
//                .ttl(10L)
//                .role("test")
//                .authId("test")
//                .build();
//
//        repository.save(token);
        redisUtils.setData("test_key", "test_value", 100000L);
    }

//    @AfterEach
//    public void deleteData(){
//        repository.deleteById("test");
//    }


    @Test
    @DisplayName("Redis search Repository 테스트")
    public void getTest(){
        Optional<RefreshToken> test = repository.findByAuthId("test");
        Assertions.assertThat(test.get().getAuthId()).isEqualTo("test");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertThat(test.isEmpty()).isEqualTo(true);
    }

    @Test
    @DisplayName("Redis search RedisTemplate 테스트")
    public void redisTemplateTest(){
        String value = redisUtils.getData("test_key");
        Assertions.assertThat(value).isEqualTo("test_value");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        value = redisUtils.getData("test_key");
        Assertions.assertThat(value).isNull();
    }
}
