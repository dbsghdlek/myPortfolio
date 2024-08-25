package com.example.portfolio.domain.user.repository;

import com.example.portfolio.domain.user.dto.UserDto;
import com.example.portfolio.domain.user.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface CustomUserRepository {

    public boolean searchLoginIdDuplicated(String loginId);
}
