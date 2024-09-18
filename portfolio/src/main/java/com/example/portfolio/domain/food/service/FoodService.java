package com.example.portfolio.domain.food.service;

import com.example.portfolio.domain.food.FoodDto;
import com.example.portfolio.domain.food.FoodEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FoodService  {

    private final FoodRepository foodRepository;

    public List<FoodDto> getListByPaging(int pageNumber) {

        return foodRepository.getFoodListByPaging(pageNumber);
    }

    public FoodDto insertFood(FoodDto foodDto){
        FoodEntity saveFood = foodRepository.save(foodDto.toEntity());
        return new FoodDto(saveFood);
    }

    public boolean updateFood(FoodDto foodDto){
        FoodEntity foodEntity = foodRepository.findById(foodDto.getId()).orElseThrow();
        return foodEntity.valueUpdate(foodDto);
    }

    public boolean deleteFood(Long foodId){
        foodRepository.deleteById(foodId);
        return true;
    }
}
