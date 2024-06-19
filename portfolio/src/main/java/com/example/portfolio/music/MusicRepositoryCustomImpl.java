package com.example.portfolio.music;

import com.example.portfolio.music.dto.MusicAndGenre;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;

import static com.example.portfolio.genre.QGenreEntity.genreEntity;
import static com.example.portfolio.music.QMusicEntity.musicEntity;

@RequiredArgsConstructor
public class MusicRepositoryCustomImpl implements MusicRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    //모든 음악 정보 가져오기
    public List<MusicAndGenre> musicAllInfo(){
        return jpaQueryFactory.select(Projections.fields(MusicAndGenre.class
                    ,musicEntity.musicID
                    , musicEntity.musicName
                    , musicEntity.genreEntity.genreId
                    , musicEntity.genreEntity.genreName))
                .from(musicEntity)
                .leftJoin(musicEntity.genreEntity, genreEntity)
                .fetch();
    }

    public List<MusicEntity> genreByMusic(Long genreId){
        List<MusicEntity> result = jpaQueryFactory.select(musicEntity)
                .from(musicEntity)
                .join(musicEntity.genreEntity, genreEntity)
                .where(genreEntity.genreId.eq(genreId))
                .fetch();
        
        return result;
    }
}
