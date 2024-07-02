package com.example.portfolio.food;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FoodService {

    private final FoodRepository foodRepository;

    public List<FoodDto> foodList(int pageNumber){
        List<FoodDto> foodList = foodRepository.getFoodList(pageNumber);
        return foodList;
    }
}
