package com.example.portfolio.domain.user.repository;

import com.example.portfolio.domain.user.entity.QAuthorityEntity;
import com.example.portfolio.domain.user.entity.QUserAutorityEntity;
import com.example.portfolio.domain.user.entity.QUserEntity;
import com.example.portfolio.domain.user.entity.UserEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.example.portfolio.domain.user.entity.QAuthorityEntity.authorityEntity;
import static com.example.portfolio.domain.user.entity.QUserAutorityEntity.userAutorityEntity;
import static com.example.portfolio.domain.user.entity.QUserEntity.userEntity;


@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<UserEntity> findOneWithAuthoritiesByUsername(String username) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(userEntity)
                .leftJoin(userEntity.authorities, userAutorityEntity)
                .join(userAutorityEntity.authority, authorityEntity)
                .where(userEntity.userName.eq(username))
                .fetchOne());
    }
}
