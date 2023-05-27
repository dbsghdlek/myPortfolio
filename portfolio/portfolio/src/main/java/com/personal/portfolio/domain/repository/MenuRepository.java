package com.personal.portfolio.domain.repository;

import com.personal.portfolio.domain.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

}
