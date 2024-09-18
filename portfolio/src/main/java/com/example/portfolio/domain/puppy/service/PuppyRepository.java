package com.example.portfolio.domain.puppy.service;

import com.example.portfolio.domain.puppy.PuppyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuppyRepository extends JpaRepository<PuppyEntity, Long>, PuppyRepositoryCustom {
}