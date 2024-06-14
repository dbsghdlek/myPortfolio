package com.example.portfolio.menu;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.portfolio.menu.QMenuEntity.menuEntity;

@Transactional
@SpringBootTest
public class Menu {

    @Autowired
    EntityManager em;

    private JPAQueryFactory queryFactory;

    @Test
    public void menuTest(){
        queryFactory = new JPAQueryFactory(em);

        List<MenuEntity> result = queryFactory
                .selectFrom(menuEntity)
                .where()
                .fetch();

        for (MenuEntity menu : result){
            System.out.println("메뉴 명 ->" + menu.getMenuName());
        }
    }
}
