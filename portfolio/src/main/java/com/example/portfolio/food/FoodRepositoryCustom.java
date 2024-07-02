package com.example.portfolio.food;

import java.util.List;

public interface FoodRepositoryCustom {
    public List<FoodDto> getFoodList(int pageNumber);
}
