package com.example.portfolio.domain.user.repository;

import com.example.portfolio.domain.user.entity.UserEntity;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long>, CustomUserRepository {


    @EntityGraph(attributePaths = "authorities")
    public Optional<UserEntity> findOneWithAuthoritiesByloginid(String loginid);
}
