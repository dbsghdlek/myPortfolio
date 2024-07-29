package com.example.portfolio.domain.music;

import com.example.portfolio.domain.music.repository.MusicRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<MusicEntity, Long>, MusicRepositoryCustom {

}
