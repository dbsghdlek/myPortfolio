package com.example.portfolio.domain.user.repository;

import com.example.portfolio.domain.user.entity.UserEntity;
import com.example.portfolio.domain.user.service.CustomUserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;


import static com.example.portfolio.domain.user.entity.QUserEntity.userEntity;
import static com.querydsl.core.group.GroupBy.list;


@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public boolean searchLoginIdDuplicated(String loginId) {
        List<UserEntity> fetch = jpaQueryFactory.selectFrom(userEntity)
                .where(userEntity.loginid.eq(loginId))
                .fetch();

        return fetch.size() >0? true:false;
    }
}
