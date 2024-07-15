package com.example.portfolio.puppy.repository;

import com.example.portfolio.puppy.PuppyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuppyRepository extends JpaRepository<PuppyEntity, Long>, PuppyRepositoryCustom {
}
