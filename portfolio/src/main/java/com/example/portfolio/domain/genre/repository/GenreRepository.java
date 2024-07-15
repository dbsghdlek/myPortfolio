package com.example.portfolio.domain.genre.repository;

import com.example.portfolio.domain.genre.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreEntity, Long>, GenreRepositoryCustom {
}
