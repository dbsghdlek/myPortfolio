package com.example.portfolio.domain.hobby.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
public class HobbyRepositoryCustomImpl implements HobbyRepositoryCustom{

    @Value("${paging.limit}")
    private int pagingLimit;

    private final JPAQueryFactory jpaQueryFactory;

}
