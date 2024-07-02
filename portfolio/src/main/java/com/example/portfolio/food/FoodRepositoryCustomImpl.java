package com.example.portfolio.food;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.portfolio.food.QFoodEntity.foodEntity;

@Repository
@RequiredArgsConstructor
public class FoodRepositoryCustomImpl implements FoodRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Value("${paging.limit}")
    private int pagingLimit;

    public List<FoodDto> getFoodList(int pageNumber){
        List<FoodDto> result = queryFactory.select(Projections.fields(FoodDto.class))
                .from(foodEntity)
                .offset(pageNumber)
                .limit(pagingLimit)
                .fetch();

        return result;
    }
}
