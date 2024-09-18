package com.example.portfolio.domain.menu.service;

import com.example.portfolio.domain.menu.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long>, MenuRepositoryCustom {
}
