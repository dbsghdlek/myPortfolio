package com.example.portfolio.domain.user.repository;

import com.example.portfolio.domain.user.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<UserEntity, Long>, CustomUserRepository {
}
