package com.example.portfolio.domain.user.repository;

import com.example.portfolio.domain.user.entity.AuthorityEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.portfolio.domain.user.entity.QAuthorityEntity.authorityEntity;

@RequiredArgsConstructor
public class AuthorityRepositoryCustomImpl implements AuthorityRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    public AuthorityEntity getUserAuthority(){
        return jpaQueryFactory.selectFrom(authorityEntity)
                .where(authorityEntity.authorityName.eq("ROLE_USER"))
                .fetchOne();
    }
}
