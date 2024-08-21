package com.example.portfolio.domain.user.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAuthKey implements Serializable {
    private Long userId;
    private String authorityName;

    public UserAuthKey(Long userId, String authorityName) {
        this.userId = userId;
        this.authorityName = authorityName;
    }
}
