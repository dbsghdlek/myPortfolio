package com.example.portfolio.domain.genre.repository;

import com.example.portfolio.domain.genre.GenreDto;
import com.example.portfolio.domain.genre.service.GenreRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.portfolio.domain.genre.QGenreEntity.genreEntity;

@RequiredArgsConstructor
public class GenreRepositoryCustomImpl implements GenreRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public List<GenreDto> genreList(){
        List<GenreDto> result = jpaQueryFactory.select(Projections.fields(GenreDto.class
                        , genreEntity.genreId
                        , genreEntity.genreName))
                .from(genreEntity)
                .fetch();

        return result;
    }
}
