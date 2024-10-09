package com.example.portfolio.domain.genre.service;

import com.example.portfolio.domain.genre.GenreEntity;
import com.example.portfolio.domain.genre.repository.GenreRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreEntity, Long>, GenreRepositoryCustom {
}
