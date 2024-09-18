package com.example.portfolio.domain.keyboard.service;

import com.example.portfolio.domain.keyboard.KeyboardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepository extends JpaRepository<KeyboardEntity, Long>, KeyboardRepositoryCustom {
}
