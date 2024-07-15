package com.example.portfolio.keyboard.repository;

import com.example.portfolio.keyboard.KeyboardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepository extends JpaRepository<KeyboardEntity, Long>, KeyboardRepositoryCustom {
}
