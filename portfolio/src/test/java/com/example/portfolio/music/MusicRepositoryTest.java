package com.example.portfolio.music;

import com.example.portfolio.genre.GenreEntity;
import com.example.portfolio.genre.repository.GenreRepository;
import com.example.portfolio.music.dto.MusicAndGenre;
import com.example.portfolio.music.dto.MusicDto;
import com.example.portfolio.music.repository.MusicRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class MusicRepositoryTest {

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Value("${paging.limit}")
    private int pagingLimit;

    @BeforeEach
    public void dataSet(){
        GenreEntity genre = GenreEntity.builder().genreId(1L).genreName("genreTest").build();
        MusicEntity music = MusicEntity.builder().musicName("test1").singerName("test1").genre(genre).build();
        genreRepository.save(genre);
        musicRepository.save(music);
    }

    @Test
    public void pagingTest(){
        List<MusicAndGenre> list = musicRepository.musicAllInfo(1);

        Assertions.assertThat(list.size()).isEqualTo(pagingLimit);
    }

    @Test
    public void getTest(){
        MusicEntity music = musicRepository.findById(1L).orElseThrow();
        MusicDto musicDto = new MusicDto(music);
        System.out.println("music = " + music.getGenreEntity().getGenreName());
        Assertions.assertThat(musicDto.getMusicName()).isEqualTo("test1");
    }

    @Test
    public void genreSearchTest(){
        List<MusicAndGenre> list = musicRepository.genreByMusic("genreTest");

        Assertions.assertThat(list.size()).isEqualTo(1);
    }
}
