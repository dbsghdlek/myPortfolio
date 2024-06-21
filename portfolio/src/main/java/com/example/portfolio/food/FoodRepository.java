package com.example.portfolio.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long>, FoodRepositoryCustom {
}
