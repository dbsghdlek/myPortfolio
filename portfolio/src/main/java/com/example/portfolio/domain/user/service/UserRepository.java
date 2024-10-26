package com.example.portfolio.domain.user.service;

import com.example.portfolio.domain.user.entity.UserEntity;

import com.example.portfolio.domain.user.repository.UserRepositoryCustom;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {

    @EntityGraph(attributePaths = "authorities")
    public Optional<UserEntity> findOneWithAuthoritiesByloginid(String loginid);
}
