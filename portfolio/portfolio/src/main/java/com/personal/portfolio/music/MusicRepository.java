package com.personal.portfolio.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MusicRepository extends JpaRepository<MusicEntity, Long>, MusicRepositoryCustom {
    @Query(value = "select m from MusicEntity m where m.genre = :genre")
    List<MusicEntity> findByGenre(@Param("genre") String genre);
}
