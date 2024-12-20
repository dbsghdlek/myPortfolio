package com.example.portfolio.domain.user.repository;

import com.example.portfolio.domain.user.entity.QUserAutorityEntity;
import com.example.portfolio.domain.user.entity.UserEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;


import static com.example.portfolio.domain.user.entity.QUserAutorityEntity.userAutorityEntity;
import static com.example.portfolio.domain.user.entity.QUserEntity.userEntity;
import static com.querydsl.core.group.GroupBy.list;


@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public boolean searchLoginIdDuplicated(String loginId) {
        List<UserEntity> fetch = jpaQueryFactory.selectFrom(userEntity)
                .where(userEntity.loginid.eq(loginId))
                .fetch();

        return fetch.size() >0? true:false;
    }

    public UserEntity getAuthorities(String loginId){
        return jpaQueryFactory.selectFrom(userEntity)
                .leftJoin(userEntity.authorities, userAutorityEntity)
                .where(userEntity.loginid.eq(loginId))
                .fetchOne();
    }
}
