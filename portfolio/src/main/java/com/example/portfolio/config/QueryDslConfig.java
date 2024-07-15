package com.example.portfolio.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@RequiredArgsConstructor
public class QueryDslConfig {

    @PersistenceContext
    private final EntityManager em;

    @Bean
    static JPAQueryFactory jpaQueryFactory(EntityManager em){
        return  new JPAQueryFactory(em);
    }
}
