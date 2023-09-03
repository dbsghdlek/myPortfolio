package com.personal.portfolio;

import com.personal.portfolio.menu.MenuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPATest {
    @Autowired
    MenuRepository menuRepository;
    @Test
    public void searchTest(){
//        Optional<Menu> optionalMenu= menuRepository.findById(1);
//        assertThat(optionalMenu.isPresent()).isEqualTo(true);
    }
}
