package com.example.portfolio.domain.menu.repository;

import com.example.portfolio.domain.menu.MenuDto;

import java.util.List;

public interface MenuRepositoryCustom {
    public List<MenuDto> findByMenuDto();
}
