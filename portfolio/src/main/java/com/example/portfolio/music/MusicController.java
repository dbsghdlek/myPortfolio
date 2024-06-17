package com.example.portfolio.music;

import com.example.portfolio.music.dto.MusicAndGenre;
import com.example.portfolio.music.dto.MusicDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/music", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MusicController {

    public final MusicRepository musicRepository;

    public final MusicService musicService;


    @Operation(summary="노래 목록 API", description="노래 목록 가져오기")
    @GetMapping("")
    public List<MusicAndGenre> MusicList(){
        List<MusicAndGenre> list = musicService.allMusic();
        return list;
    }



    @Operation(summary="노래 단일 정보 API", description="단일 노래 정보 가져오기")
    @GetMapping("/{musicId}")
    public MusicDto musicInfoRequest(@PathVariable("musicId") Long musicId){
        MusicDto musicDto =musicService.getMusic(musicId);
        return musicDto;
    }
}
