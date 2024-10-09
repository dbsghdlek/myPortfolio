package com.example.portfolio.music;

import com.example.portfolio.domain.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MusicServiceTest {

    @Autowired
    MusicService service;


}
