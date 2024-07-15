package com.example.portfolio.domain.food;

import com.example.portfolio.domain.food.repository.FoodRepository;
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
}
