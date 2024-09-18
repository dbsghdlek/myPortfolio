package com.example.portfolio.hobby;

import com.example.portfolio.config.QueryDslConfig;
import com.example.portfolio.domain.hobby.HobbyDto;
import com.example.portfolio.domain.hobby.service.HobbyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;

@DataJpaTest
@Import(QueryDslConfig.class)
public class HobbyRepositoryTest {

    @Autowired
    HobbyRepository repository;

    @Test
    public void insertTest(){
        HobbyDto hobbyDto = HobbyDto.builder().hobbyName("Test").build();
        hobbyDto.setCreateDate(LocalDateTime.now());
        Assertions.assertThat(repository.save(hobbyDto.toEntity()).getHobbyName()).isEqualTo(hobbyDto.getHobbyName());
    }
}
