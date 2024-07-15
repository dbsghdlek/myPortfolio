package com.example.portfolio.domain.music.repository;

import com.example.portfolio.domain.music.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<MusicEntity, Long>, MusicRepositoryCustom {

}
