package com.example.portfolio.domain.music.service;

import com.example.portfolio.domain.music.MusicEntity;
import com.example.portfolio.domain.music.repository.MusicRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<MusicEntity, Long>, MusicRepositoryCustom {

}
