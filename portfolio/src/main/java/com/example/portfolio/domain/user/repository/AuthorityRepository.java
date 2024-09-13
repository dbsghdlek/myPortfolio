package com.example.portfolio.domain.user.repository;

import com.example.portfolio.domain.user.entity.AuthorityEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String>, CustomAuthorityRepository {
}
