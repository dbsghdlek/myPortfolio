package com.example.portfolio.music;

import com.example.portfolio.genre.QGenreEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
public class Music {
    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @BeforeEach
    public void beforeMethod(){
        queryFactory = new JPAQueryFactory(em);
    }

    @Test
    public void musicAndGenreJoin(){
        List<MusicEntity> result = queryFactory
                .selectFrom(QMusicEntity.musicEntity)
                .join(QMusicEntity.musicEntity.genreEntity, QGenreEntity.genreEntity)
                .fetchJoin()
                .fetch();

        for(MusicEntity music : result){
            System.out.println("뮤직 ->" + music.getMusicName() + " " + music.getGenreEntity().getGenreName());
        }
    }
}
