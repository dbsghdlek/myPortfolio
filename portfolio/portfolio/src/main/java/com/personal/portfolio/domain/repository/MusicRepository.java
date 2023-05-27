package com.personal.portfolio.domain.repository;

import com.personal.portfolio.domain.entity.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<MusicEntity, Integer> {
}
