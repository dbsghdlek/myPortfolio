package com.personal.portfolio.music;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MusicRepository extends JpaRepository<Music, Long>, MusicRepositoryCustom {
    @Query(value = "select m from Music m inner join m.genre g where g.genreNo = :genreNo")
    List<Music> findByGenre(@Param("genreNo") int genreNo, Pageable pageable);
}
