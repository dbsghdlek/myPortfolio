package com.example.portfolio.keyboard.repository;

import com.example.portfolio.keyboard.KeyboardDto;

import java.util.List;

public interface KeyboardRepositoryCustom {
    public List<KeyboardDto> keyboardDtoList(int pageNumber);
}
