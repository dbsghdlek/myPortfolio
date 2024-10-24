package com.example.portfolio.music;

import com.example.portfolio.domain.music.service.MusicService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MusicTestConfig {

    @Bean
    public MusicService musicService(){
        return Mockito.mock(MusicService.class);
    }
}
