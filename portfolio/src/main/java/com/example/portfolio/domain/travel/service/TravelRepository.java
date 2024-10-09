package com.example.portfolio.domain.travel.service;

import com.example.portfolio.domain.travel.TravelEntity;
import com.example.portfolio.domain.travel.repository.TravelRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TravelRepository extends JpaRepository<TravelEntity, Long>, TravelRepositoryCustom {
}
