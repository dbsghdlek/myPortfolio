package com.personal.portfolio.web.controller;

import com.personal.portfolio.domain.dto.Music;
import com.personal.portfolio.domain.repository.MusicRepository;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/music", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MusicController {
    public final MusicRepository musicRepository;

    @ApiOperation(value="노래 목록 API", notes="노래 목록 가져오기")
    @GetMapping("/list")
    public List<Music> MusicList(){
        return musicRepository.getMusicList();
    }
    @ApiOperation(value="노래 목록 API", notes="노래 목록 가져오기")
    @GetMapping("/{musicName}")
    public Music musicInfoRequest(@PathVariable("musicName") String musicName){
        Music music = musicRepository.musicFind(musicName).orElse(null);
        return music;
    }

}
