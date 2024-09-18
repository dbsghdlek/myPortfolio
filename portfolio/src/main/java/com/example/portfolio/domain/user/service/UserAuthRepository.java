package com.example.portfolio.domain.user.service;

import com.example.portfolio.domain.user.entity.UserAuthKey;
import com.example.portfolio.domain.user.entity.UserAutorityEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface UserAuthRepository extends JpaRepository<UserAutorityEntity, UserAuthKey> {
}
