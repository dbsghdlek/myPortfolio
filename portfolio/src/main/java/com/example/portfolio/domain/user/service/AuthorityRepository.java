package com.example.portfolio.domain.user.service;

import com.example.portfolio.domain.user.entity.AuthorityEntity;
import com.example.portfolio.domain.user.repository.AuthorityRepositoryCustom;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String>, AuthorityRepositoryCustom {
}
