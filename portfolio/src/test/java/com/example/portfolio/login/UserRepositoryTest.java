package com.example.portfolio.login;

import com.example.portfolio.config.QueryDslConfig;
import com.example.portfolio.domain.user.entity.AuthorityEntity;
import com.example.portfolio.domain.user.entity.UserAuthKey;
import com.example.portfolio.domain.user.entity.UserAutorityEntity;
import com.example.portfolio.domain.user.entity.UserEntity;
import com.example.portfolio.domain.user.service.AuthorityRepository;
import com.example.portfolio.domain.user.service.UserAuthRepository;
import com.example.portfolio.domain.user.service.UserRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

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
        // 신규 유저
        UserEntity user = UserEntity.builder().username("test1").loginid("test").password("test").build();
        // 신규 권한
        AuthorityEntity authority = AuthorityEntity.builder().authorityName("ROLE_USER").build();
        AuthorityEntity adminAuthority = AuthorityEntity.builder().authorityName("ROLE_ADMIN").build();
        // 중간 테이블인 UserAhthority insert하여 등록
        UserAutorityEntity userAutority = UserAutorityEntity.builder()
                .userAuthKey(new UserAuthKey(user.getId(), authority.getAuthorityName()))
                .user(user)
                .authority(authority).build();

        UserAutorityEntity userAdminAutority = UserAutorityEntity.builder()
                .userAuthKey(new UserAuthKey(user.getId(), authority.getAuthorityName()))
                .user(user)
                .authority(adminAuthority).build();

        userAuthRepository.saveAndFlush(userAutority);
        userAuthRepository.saveAndFlush(userAdminAutority);

        entityManager.clear();
    }
    @Test
    void manyTomanyTest(){
        UserEntity test1 = userRepository.findOneWithAuthoritiesByloginid("test").orElseThrow();
        Assertions.assertThat(test1.getAuthorities().iterator().next().getAuthority().getAuthorityName()).isEqualTo("ADMIN");
    }

    
    @Test
    void duplicatedLoginIdTest(){
        boolean test = userRepository.searchLoginIdDuplicated("test");
        boolean test1 = userRepository.searchLoginIdDuplicated("test1");
        Assertions.assertThat(test).isEqualTo(true);
        Assertions.assertThat(test1).isEqualTo(false);
    }

    @Test
    void searchByLoginIdTest(){
        UserEntity test = userRepository.findByloginid("test").orElseThrow();
        System.out.println("test = " + test.getUsername());
    }

    @Test
    void getAuthoritiesTest(){
        UserEntity test = userRepository.getAuthorities("test");
        test.getAuthorities().stream().forEach(auth ->{
            System.out.println("auth.getAuthority() = " + auth.getAuthority().getAuthorityName());
        });
    }
}
