package com.example.portfolio.domain.user.repository;

import com.example.portfolio.domain.user.entity.QUserAutorityEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.portfolio.domain.user.entity.QUserAutorityEntity.userAutorityEntity;

@RequiredArgsConstructor
public class UserAuthRepositoryCustomImpl implements UserAuthRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;


}
