package com.example.portfolio.domain.food.repository;

import com.example.portfolio.domain.food.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long>, FoodRepositoryCustom {
}
