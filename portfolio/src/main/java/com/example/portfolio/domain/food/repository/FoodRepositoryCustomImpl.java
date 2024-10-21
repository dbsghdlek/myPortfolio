package com.example.portfolio.domain.food.repository;

import com.example.portfolio.domain.food.dto.FoodDto;
import com.example.portfolio.domain.food.entity.QFoodEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.portfolio.domain.food.entity.QFoodEntity.foodEntity;


@Repository
@RequiredArgsConstructor
public class FoodRepositoryCustomImpl implements FoodRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Value("${paging.limit}")
    private int pagingLimit;

    public List<FoodDto> getFoodListByPaging(int pageNumber){
        List<FoodDto> result = queryFactory.select(Projections.fields(FoodDto.class))
                .from(foodEntity)
                .offset(pageNumber)
                .limit(pagingLimit)
                .fetch();

        return result;
    }
}
