package com.example.portfolio.music;

import com.example.portfolio.music.dto.MusicAndGenre;
import com.example.portfolio.music.repository.MusicRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class MusicRepositoryTest {

    @Autowired
    private MusicRepository musicRepository;

    @Value("${paging.limit}")
    private int pagingLimit;

    @BeforeEach
    public void dataSet(){
        musicRepository.save(MusicEntity.builder().musicName("test1").singerName("test1").build());
        musicRepository.save(MusicEntity.builder().musicName("test2").singerName("test1").build());
        musicRepository.save(MusicEntity.builder().musicName("test3").singerName("test1").build());
        musicRepository.save(MusicEntity.builder().musicName("test4").singerName("test1").build());
        musicRepository.save(MusicEntity.builder().musicName("test5").singerName("test1").build());
        musicRepository.save(MusicEntity.builder().musicName("test6").singerName("test1").build());
        musicRepository.save(MusicEntity.builder().musicName("test7").singerName("test1").build());
        musicRepository.save(MusicEntity.builder().musicName("test8").singerName("test1").build());
    }

    @Test
    public void pagingTest(){
        List<MusicAndGenre> list = musicRepository.musicAllInfo(1);

        Assertions.assertThat(list.size()).isEqualTo(pagingLimit);
    }
}
