package com.example.portfolio.domain.hobby.repository;

import com.example.portfolio.domain.hobby.HobbyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<HobbyEntity, Integer>,HobbyRepositoryCustom {

}
