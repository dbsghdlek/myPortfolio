package com.example.portfolio.food;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.portfolio.food.QFoodEntity.foodEntity;

@Repository
@RequiredArgsConstructor
public class FoodRepositoryCustomImpl implements FoodRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public List<FoodDto> getFoodList(){
        List<FoodDto> result = queryFactory.select(Projections.fields(FoodDto.class))
                .from(foodEntity)
                .fetch();

        return result;
    }
}
