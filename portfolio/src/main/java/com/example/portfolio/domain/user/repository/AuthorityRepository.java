package com.example.portfolio.domain.user.repository;

import com.example.portfolio.domain.user.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String> {
}
