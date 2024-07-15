package com.example.portfolio.domain.travel.repository;

import com.example.portfolio.domain.travel.TravelEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TravelRepository extends JpaRepository<TravelEntity, Long>, TravelRepositoryCustom {
}
