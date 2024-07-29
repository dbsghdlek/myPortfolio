package com.example.portfolio.domain.keyboard;

import com.example.portfolio.domain.keyboard.repository.KeyboardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepository extends JpaRepository<KeyboardEntity, Long>, KeyboardRepositoryCustom {
}
