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

import static com.example.portfolio.genre.QGenreEntity.genreEntity;
import static com.example.portfolio.music.QMusicEntity.musicEntity;


@Transactional
public class MusicServiceTest {

    @Autowired
    private MusicService musicService;
}
