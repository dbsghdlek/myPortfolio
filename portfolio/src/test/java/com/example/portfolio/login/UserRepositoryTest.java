package com.example.portfolio.login;

import com.example.portfolio.config.QueryDslConfig;
import com.example.portfolio.domain.user.entity.AuthorityEntity;
import com.example.portfolio.domain.user.entity.UserAutorityEntity;
import com.example.portfolio.domain.user.entity.UserEntity;
import com.example.portfolio.domain.user.repository.AuthorityRepository;
import com.example.portfolio.domain.user.repository.UserAuthRepository;
import com.example.portfolio.domain.user.repository.UserRepository;
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

    @BeforeEach
    void beforeSetting(){
        UserEntity user = UserEntity.builder().userName("test").loginId("test").password("test").build();
//        AuthorityEntity authority = AuthorityEntity.builder().authorityName("ADMIN").build();
//        UserAutorityEntity userAutority = UserAutorityEntity.builder().user(user).authority(authority).build();

//        userRepository.save(user);
//        authorityRepository.save(authority);
//        userAuthRepository.save(userAutority);
    }
    @Test
    void mtmTest(){
//        UserEntity user = userRepository.findOneWithAuthoritiesByUsername("test").get();
//
//        System.out.println(user.getUserName() + "/ " + user.getAuthorities().stream().map(authority -> authority.getAuthority().getAuthorityName()));
    }

}
