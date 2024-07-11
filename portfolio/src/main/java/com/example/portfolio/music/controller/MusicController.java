package com.example.portfolio.music.controller;

import com.example.portfolio.domain.controller.BaseController;
import com.example.portfolio.domain.result.ResponseResult;
import com.example.portfolio.domain.result.Result;
import com.example.portfolio.music.MusicService;
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

    public final MusicService service;

    @Operation(summary="노래 목록 API", description="노래 목록 가져오기")
    @GetMapping("")
    public Result MusicList(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNUmber){
        List<MusicAndGenre> list = service.allMusic(pageNUmber);
        return ResponseResult.wrapperResult(list);
    }

    @Operation(summary="노래 단일 정보 API", description="단일 노래 정보 가져오기")
    @GetMapping("/{musicId}")
    public Result musicInfoRequest(@PathVariable("musicId") Long musicId){
        MusicDto musicDto =service.getMusic(musicId);
        return ResponseResult.wrapperResult(musicDto);
    }
}
