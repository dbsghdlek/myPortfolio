package com.example.portfolio.genre.repository;

import com.example.portfolio.genre.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreEntity, Long>, GenreRepositoryCustom {
}
