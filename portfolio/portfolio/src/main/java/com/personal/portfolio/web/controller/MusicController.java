package com.personal.portfolio.web.controller;

import com.personal.portfolio.domain.entity.MusicEntity;
import com.personal.portfolio.domain.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/music", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MusicController {
    public final MusicRepository musicRepository;
    @GetMapping("/list")
    public List<MusicEntity> MusicList(){
        return musicRepository.getMusicList();
    }
}
