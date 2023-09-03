package com.personal.portfolio.music;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MusicRepositoryCustomImpl implements MusicRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Music findMusic(Long musicId) {
        return null;
    }
}
