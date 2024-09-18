package com.example.portfolio.menu;

import com.example.portfolio.config.QueryDslConfig;
import com.example.portfolio.domain.menu.MenuDto;
import com.example.portfolio.domain.menu.MenuEntity;
import com.example.portfolio.domain.menu.service.MenuRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(QueryDslConfig.class)
public class MenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;

    MenuEntity menu = MenuEntity.builder().menuName("Test").build();

    @BeforeEach
    public void insert(){
        menuRepository.save(menu);
    }

    @Test
    public void getTest(){
        List<MenuDto> menuDto = menuRepository.findByMenuDto();

        Assertions.assertThat(menuDto.size()).isNotEqualTo(0);
    }

    @Test
    public void insertTest(){
        MenuEntity menu2 = menuRepository.findById(menu.getMenuId()).orElseThrow();

        Assertions.assertThat(menu2.getMenuId()).isEqualTo(menu.getMenuId());
    }
}
