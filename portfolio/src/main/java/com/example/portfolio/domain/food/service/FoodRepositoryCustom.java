package com.example.portfolio.domain.food.service;

import com.example.portfolio.domain.food.FoodDto;

import java.util.List;

public interface FoodRepositoryCustom {
    public List<FoodDto> getFoodListByPaging(int pageNumber);
}
