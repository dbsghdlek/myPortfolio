package com.example.portfolio.hobby.repository;

import com.example.portfolio.hobby.HobbyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<HobbyEntity, Integer>,HobbyRepositoryCustom {

}
