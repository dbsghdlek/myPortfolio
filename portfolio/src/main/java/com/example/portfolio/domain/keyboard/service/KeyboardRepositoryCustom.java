package com.example.portfolio.domain.keyboard.service;

import com.example.portfolio.domain.keyboard.KeyboardDto;

import java.util.List;

public interface KeyboardRepositoryCustom {
    public List<KeyboardDto> keyboardDtoList(int pageNumber);
}
