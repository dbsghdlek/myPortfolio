package com.example.portfolio.puppy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PuppyRepository extends JpaRepository<PuppyEntity, Long>, PuppyRepositoryCustom {
}
