package com.example.portfolio.music.repository;

import com.example.portfolio.music.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<MusicEntity, Long>, MusicRepositoryCustom {

}
