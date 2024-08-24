package com.example.portfolio.login;

import com.example.portfolio.config.QueryDslConfig;
import com.example.portfolio.domain.user.entity.AuthorityEntity;
import com.example.portfolio.domain.user.entity.UserAuthKey;
import com.example.portfolio.domain.user.entity.UserAutorityEntity;
import com.example.portfolio.domain.user.entity.UserEntity;
import com.example.portfolio.domain.user.repository.AuthorityRepository;
import com.example.portfolio.domain.user.repository.UserAuthRepository;
import com.example.portfolio.domain.user.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

@DataJpaTest
@Import(QueryDslConfig.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    EntityManager entityManager;

    @BeforeEach
    void beforeSetting(){
        UserEntity user = UserEntity.builder().username("test1").loginid("test").password("test").build();
        AuthorityEntity authority = AuthorityEntity.builder().authorityName("ADMIN").build();
        UserAutorityEntity userAutority = UserAutorityEntity.builder()
                .userAuthKey(new UserAuthKey(user.getId(), authority.getAuthorityName()))
                .user(user)
                .authority(authority).build();

        userAuthRepository.saveAndFlush(userAutority);

        entityManager.clear();
    }
    @Test
    void manyTomanyTest(){
        UserEntity test1 = userRepository.findOneWithAuthoritiesByloginid("test").orElseThrow();
        Assertions.assertThat(test1.getAuthorities().iterator().next().getAuthority().getAuthorityName()).isEqualTo("ADMIN");
    }

}
