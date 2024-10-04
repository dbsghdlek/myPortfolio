package com.example.portfolio.domain.hobby.repository;

import com.example.portfolio.domain.hobby.HobbyDto;
import com.example.portfolio.domain.hobby.QHobbyEntity;
import com.example.portfolio.domain.hobby.service.HobbyRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static com.example.portfolio.domain.hobby.QHobbyEntity.hobbyEntity;

@RequiredArgsConstructor
public class HobbyRepositoryCustomImpl implements HobbyRepositoryCustom {

    @Value("${paging.limit}")
    private int pagingLimit;

    private final JPAQueryFactory jpaQueryFactory;

    public List<HobbyDto> getHobbyList(int pageNumber){
        return jpaQueryFactory.select(Projections.fields(HobbyDto.class
                        , hobbyEntity.hobbyId
                        , hobbyEntity.hobbyName))
                .from(hobbyEntity)
                .offset(pageNumber)
                .limit(pagingLimit)
                .fetch();
    }

}
