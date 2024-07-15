package com.example.portfolio.domain.music.repository;

import com.example.portfolio.domain.genre.QGenreEntity;
import com.example.portfolio.domain.music.QMusicEntity;
import com.example.portfolio.domain.music.dto.MusicAndGenre;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static com.example.portfolio.domain.genre.QGenreEntity.genreEntity;
import static com.example.portfolio.domain.music.QMusicEntity.musicEntity;

@RequiredArgsConstructor
public class MusicRepositoryCustomImpl implements MusicRepositoryCustom{

    @Value("${paging.limit}")
    private int pagingLimit;

    private final JPAQueryFactory jpaQueryFactory;

    //음악 정보 가져오기 페이징 적용
    public List<MusicAndGenre> musicAllInfo(int pageNumber){
        return jpaQueryFactory.select(Projections.fields(MusicAndGenre.class
                    , musicEntity.musicID
                    , musicEntity.musicName
                    , musicEntity.genreEntity.genreId
                    , musicEntity.genreEntity.genreName))
                .from(musicEntity)
                .leftJoin(musicEntity.genreEntity, genreEntity)
                .offset(pageNumber)
                .limit(pagingLimit)
                .fetch();
    }

    public List<MusicAndGenre> genreByMusic(String genreName){
        return jpaQueryFactory.select(Projections.fields(MusicAndGenre.class
                ,musicEntity.musicID
                , musicEntity.musicName
                , musicEntity.musicImage
                , musicEntity.createDate
                , musicEntity.modifiedDate
                , musicEntity.genreEntity.genreId
                , musicEntity.genreEntity.genreName))
                .from(musicEntity)
                .join(musicEntity.genreEntity, genreEntity)
                .where(genreEntity.genreName.eq(genreName))
                .fetch();
    }
}
