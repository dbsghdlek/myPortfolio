package com.example.portfolio.config.redis;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RedisHash(value = "refresh_token")
public class RefreshToken {

    @Id
    private String authId;

    @Indexed
    private String token;

    private String role;

    @TimeToLive
    private Long ttl;

    public RefreshToken update(String token, long ttl){
        this.token = token;
        this.ttl = ttl;
        return this;
    }
}
