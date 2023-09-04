package com.personal.portfolio.music;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MusicRepository extends JpaRepository<Music, Long>, MusicRepositoryCustom {
    @Query(value = "select m from Music m where m.genre = :genre")
    List<Music> findByGenre(@Param("genre") Genre genre, Pageable pageable);
    @Query(value = "select m from Music m where m.singerName =:singerName")
    List<Music> findBySinger(@Param("singerName") String singerName, Pageable pageable);
}
