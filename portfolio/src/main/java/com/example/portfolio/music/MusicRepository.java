package com.example.portfolio.music;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<MusicEntity, Long>, MusicRepositoryCustom {

}
