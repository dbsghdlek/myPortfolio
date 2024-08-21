package com.example.portfolio.domain.user.repository;

import static com.example.portfolio.domain.user.entity.QAuthorityEntity.authorityEntity;
import static com.example.portfolio.domain.user.entity.QUserAutorityEntity.userAutorityEntity;
import static com.querydsl.core.group.GroupBy.groupBy;

import com.example.portfolio.domain.user.dto.UserDto;
import com.example.portfolio.domain.user.entity.QAuthorityEntity;
import com.example.portfolio.domain.user.entity.QUserAutorityEntity;
import com.example.portfolio.domain.user.entity.UserEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.example.portfolio.domain.user.entity.QUserEntity.userEntity;
import static com.querydsl.core.group.GroupBy.list;


@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository{

    private final JPAQueryFactory jpaQueryFactory;

}
