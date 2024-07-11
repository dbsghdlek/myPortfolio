package com.example.portfolio.food.repository;

import com.example.portfolio.food.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long>, FoodRepositoryCustom {
}
