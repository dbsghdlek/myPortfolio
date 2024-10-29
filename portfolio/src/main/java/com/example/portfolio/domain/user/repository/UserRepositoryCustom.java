package com.example.portfolio.domain.user.repository;

import com.example.portfolio.domain.user.entity.UserEntity;

import java.util.List;

public interface UserRepositoryCustom {
    public boolean searchLoginIdDuplicated(String loginId);

    public UserEntity getAuthorities(String loginId);
}
