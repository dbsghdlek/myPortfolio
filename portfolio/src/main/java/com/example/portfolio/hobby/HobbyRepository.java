package com.example.portfolio.hobby;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<HobbyEntity, Integer>,HobbyRepositoryCustom {

}
