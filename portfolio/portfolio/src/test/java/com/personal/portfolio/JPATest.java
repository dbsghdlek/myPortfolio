package com.personal.portfolio;

import com.personal.portfolio.domain.entity.MenuEntity;
import com.personal.portfolio.domain.repository.MenuRepository;
import com.personal.portfolio.web.dto.MenuDto;
import com.personal.portfolio.web.service.MenuService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class JPATest {
    @Autowired
    MenuRepository menuRepository;
    @Test
    public void searchTest(){
        Optional<MenuEntity> menu = menuRepository.findById(2);
        menu.orElse()
        assertThat(menu.isPresent()).isEqualTo(true);
    }
}
