package com.example.portfolio.domain.menu;

import com.example.portfolio.domain.menu.repository.MenuRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long>, MenuRepositoryCustom {
}
