package com.example.portfolio.domain.puppy;

import com.example.portfolio.domain.puppy.repository.PuppyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuppyRepository extends JpaRepository<PuppyEntity, Long>, PuppyRepositoryCustom {
}