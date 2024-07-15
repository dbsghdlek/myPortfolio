package com.example.portfolio.puppy;

import com.example.portfolio.config.QueryDslConfig;
import com.example.portfolio.domain.puppy.PuppyDto;
import com.example.portfolio.domain.puppy.PuppyEntity;
import com.example.portfolio.domain.puppy.repository.PuppyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@DataJpaTest
@Import(QueryDslConfig.class)
public class PuppyRepositoryTest {

    @Autowired
    PuppyRepository repository;

    @BeforeEach
    public void dataSetting(){
        repository.save(PuppyEntity.builder().puppyName("달이").pictureName("test1").build());
        repository.save(PuppyEntity.builder().puppyName("달이").pictureName("test2").build());
        repository.save(PuppyEntity.builder().puppyName("별이").pictureName("test3").build());
        repository.save(PuppyEntity.builder().puppyName("별이").pictureName("test4").build());
    }

    @Test
    public void groupSearchTest(){
        List<PuppyDto> list = repository.searching("달이");
        Assertions.assertThat(list.size()).isEqualTo(2);
    }
}
