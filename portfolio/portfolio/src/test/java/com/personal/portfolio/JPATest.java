package com.personal.portfolio;

import com.personal.portfolio.menu.MenuEntity;
import com.personal.portfolio.menu.MenuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class JPATest {
    @Autowired
    MenuRepository menuRepository;
    @Test
    public void searchTest(){
        Optional<MenuEntity> optionalMenu= menuRepository.findById(1);
        assertThat(optionalMenu.isPresent()).isEqualTo(true);
    }
}
