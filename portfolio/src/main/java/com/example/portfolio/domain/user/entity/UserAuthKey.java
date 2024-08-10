package com.example.portfolio.domain.user.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UserAuthKey implements Serializable {
    private Long userId;
    private String authorityName;
}
