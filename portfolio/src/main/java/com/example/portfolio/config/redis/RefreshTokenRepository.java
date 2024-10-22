package com.example.portfolio.config.redis;

import org.springframework.data.repository.CrudRepository;

import java.sql.Ref;
import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByAuthId(String authId);


}
