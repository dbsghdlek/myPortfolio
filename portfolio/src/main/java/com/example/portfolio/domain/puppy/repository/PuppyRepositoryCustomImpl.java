package com.example.portfolio.domain.puppy.repository;

import com.example.portfolio.domain.puppy.PuppyDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static com.example.portfolio.domain.puppy.QPuppyEntity.puppyEntity;


@RequiredArgsConstructor
public class PuppyRepositoryCustomImpl implements PuppyRepositoryCustom {

    @Value("${paging.limit}")
    private int pagingLimit;

    private final JPAQueryFactory jpaQueryFactory;


    public List<PuppyDto> searchingByPuppyName(String puppyName, int pageNumber){
        return jpaQueryFactory.select(Projections.fields(PuppyDto.class
                    , puppyEntity.pictureId
                    , puppyEntity.pictureName
                    , puppyEntity.puppyName
                    , puppyEntity.pictureDate
                ))
                .from(puppyEntity)
                .where(puppyNameEq(puppyName))
                .offset(pageNumber)
                .limit(pagingLimit)
                .fetch();
    }

    public BooleanExpression puppyNameEq(String puppyName){
        return puppyName != null ?puppyEntity.puppyName.eq(puppyName): null;
    }
}
