package com.example.portfolio.config.redis;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    public Optional<RefreshToken> findByToken(String token);

    public Optional<RefreshToken> findByAuthId(String authId);
}
