package com.example.portfolio.travel;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
public class TravelRepositoryCustomImpl implements TravelRepositoryCustom{

    @Value("${paging.limit}")
    private int pagingLimit;

    private final JPAQueryFactory jpaQueryFactory;
}
