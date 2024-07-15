package com.example.portfolio.food.repository;

import com.example.portfolio.food.FoodDto;

import java.util.List;

public interface FoodRepositoryCustom {
    public List<FoodDto> getFoodListByPaging(int pageNumber);
}
