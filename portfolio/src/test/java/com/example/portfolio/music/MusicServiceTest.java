package com.example.portfolio.music;

import com.example.portfolio.music.dto.MusicDto;
import com.example.portfolio.music.repository.MusicRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MusicServiceTest {

    @Autowired
    MusicService service;


}
