package com.personal.portfolio.menu;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MenuRepositoryCustomImpl implements MenuRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    @Override
    public MenuEntity getMenuUsingQueryDsl(Long menuId) {
        QMenuEntity menuEntity = QMenuEntity.menuEntity;

        return queryFactory.selectFrom(menuEntity)
                .where(menuEntity.menuId.eq(menuId)).fetchOne();
    }
}
