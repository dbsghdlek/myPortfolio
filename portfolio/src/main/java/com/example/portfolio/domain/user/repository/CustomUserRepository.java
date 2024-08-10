package com.example.portfolio.domain.user.repository;

import com.example.portfolio.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.Optional;

public interface CustomUserRepository {

    Optional<UserEntity> findOneWithAuthoritiesByUsername(String username);
}
