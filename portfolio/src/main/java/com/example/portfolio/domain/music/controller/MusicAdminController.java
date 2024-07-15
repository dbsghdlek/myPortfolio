package com.example.portfolio.music.controller;

import com.example.portfolio.domain.base.controller.BaseController;
import com.example.portfolio.domain.result.ResponseResult;
import com.example.portfolio.music.MusicService;
import com.example.portfolio.music.dto.MusicDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin/music", produces = MediaType.APPLICATION_JSON_VALUE)
public class MusicAdminController extends BaseController{

    private final MusicService service;

    @Operation(summary = "음악 추가 Api", description ="음악 데이터 추가하기" )
    @PostMapping("/")
    public ResponseEntity insertMusic(@RequestBody MusicDto dto){
        boolean result = service.insert(dto);
        return new ResponseEntity(ResponseResult.wrapperResult(result), HttpStatus.OK);
    }

    @Operation(summary = "음악 정보 변경 Api", description = "음악 데이터 수정하기")
    @PutMapping("/update/{musicId}")
    public ResponseEntity updateMusic(@RequestBody MusicDto dto, @PathVariable Long musicId){
        dto.setMusicID(musicId);
        boolean result = service.update(dto);
        return new ResponseEntity(ResponseResult.wrapperResult(result), HttpStatus.OK);
    }

    @Operation(summary = "음악 삭제 Api",description = "음악 데이터 삭제하기")
    @DeleteMapping("/delete/{musicId}")
    public ResponseEntity deleteMusic(@PathVariable Long musicId){
        boolean result = service.delete(musicId);
        return new ResponseEntity<>(ResponseResult.wrapperResult(result), HttpStatus.OK);
    }
}
