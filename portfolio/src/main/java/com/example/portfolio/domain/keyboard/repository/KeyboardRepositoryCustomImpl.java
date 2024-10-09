package com.example.portfolio.domain.keyboard.repository;

import com.example.portfolio.domain.keyboard.KeyboardDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static com.example.portfolio.domain.keyboard.QKeyboardEntity.keyboardEntity;

@RequiredArgsConstructor
public class KeyboardRepositoryCustomImpl implements KeyboardRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    
    @Value("${paging.limit}")
    private int pagingLimit;
    
    public List<KeyboardDto> keyboardDtoList(int pageNumber){
        List<KeyboardDto> result = queryFactory
                .select(Projections.fields(KeyboardDto.class
                        , keyboardEntity.keyboardId
                        , keyboardEntity.keyboardImage
                        , keyboardEntity.reinforcePlate
                        , keyboardEntity.company
                        , keyboardEntity.keyCap
                        , keyboardEntity.keyboardImage
                        ))
                .from(keyboardEntity)
                .offset(pageNumber)
                .limit(pagingLimit)
                .fetch();
        
        return result;
    }

}
