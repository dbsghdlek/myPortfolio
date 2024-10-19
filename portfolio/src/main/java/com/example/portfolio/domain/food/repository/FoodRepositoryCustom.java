package com.example.portfolio.domain.food.repository;

import com.example.portfolio.domain.food.dto.FoodDto;

import java.util.List;

public interface FoodRepositoryCustom {
    public List<FoodDto> getFoodListByPaging(int pageNumber);
}
