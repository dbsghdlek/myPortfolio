package com.example.portfolio.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<MenuEntity, Long>, MenuRepositoryCustom {
}
