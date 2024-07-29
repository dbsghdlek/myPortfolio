package com.example.portfolio.domain.food;

import com.example.portfolio.domain.food.repository.FoodRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long>, FoodRepositoryCustom {
}
