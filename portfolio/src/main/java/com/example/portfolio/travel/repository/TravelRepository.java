package com.example.portfolio.travel.repository;

import com.example.portfolio.travel.TravelEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TravelRepository extends JpaRepository<TravelEntity, Long>, TravelRepositoryCustom {
}
