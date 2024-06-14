package com.example.portfolio.genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
}
