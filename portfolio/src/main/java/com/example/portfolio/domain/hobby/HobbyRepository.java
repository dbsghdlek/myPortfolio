package com.example.portfolio.domain.hobby;

import com.example.portfolio.domain.hobby.repository.HobbyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<HobbyEntity, Integer>, HobbyRepositoryCustom {

}
