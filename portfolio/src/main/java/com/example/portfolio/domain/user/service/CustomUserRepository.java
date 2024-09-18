package com.example.portfolio.domain.user.service;

public interface CustomUserRepository {

    public boolean searchLoginIdDuplicated(String loginId);
}
