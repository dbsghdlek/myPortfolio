package com.example.portfolio.domain.music.controller;

import com.example.portfolio.domain.base.BaseController;
import com.example.portfolio.domain.music.MusicService;
import com.example.portfolio.domain.music.dto.MusicAndGenre;
import com.example.portfolio.domain.music.dto.MusicDto;
import com.example.portfolio.web.response.result.ResultResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/music", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MusicController extends BaseController{

    public final MusicService service;

    @Operation(summary="노래 목록 API", description="노래 목록 가져오기")
    @GetMapping("")
    public ResponseEntity MusicList(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNUmber){
        List<MusicAndGenre> list = service.allMusic(pageNUmber);
        return ResultResponse.wrapperResult(list);
    }

    @Operation(summary="노래 단일 정보 API", description="단일 노래 정보 가져오기")
    @GetMapping("/{musicId}")
    public ResponseEntity musicInfoRequest(@PathVariable("musicId") Long musicId){
        MusicDto musicDto =service.getSingle(musicId);
        return ResultResponse.wrapperResult(musicDto);
    }

    @GetMapping("/genre/{genreName}")
    public ResponseEntity genreByList(@PathVariable String genreName){
        List<MusicAndGenre> list = service.getListByGenre(genreName);

        return ResultResponse.wrapperResult(list);
    }
}
