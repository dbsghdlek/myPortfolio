package com.example.portfolio.travel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepository extends JpaRepository<Long, TravelEntity>, TravelRepositoryCustom {
}
