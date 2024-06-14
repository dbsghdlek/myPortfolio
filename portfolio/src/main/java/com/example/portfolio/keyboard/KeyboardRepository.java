package com.example.portfolio.keyboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepository extends JpaRepository<KeyboardEntity, Long> {
}
