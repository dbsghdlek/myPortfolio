package com.example.portfolio.menu.repository;

import com.example.portfolio.menu.MenuDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.portfolio.menu.QMenuEntity.menuEntity;

@Repository
@RequiredArgsConstructor
public class MenuRepositoryCustomImpl implements MenuRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    public List<MenuDto> findByMenuDto(){
        return jpaQueryFactory.select(Projections
                        .fields(MenuDto.class,
                                menuEntity.menuId,
                                menuEntity.menuName))
                .from(menuEntity)
                .fetch();

    }
}
