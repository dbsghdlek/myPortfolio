package com.personal.portfolio.music;

import com.personal.portfolio.error.ErrorCodeEnum;
import com.personal.portfolio.error.ErrorVO;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/music", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MusicController {
    public final MusicRepository musicRepository;

    public final MusicService musicService;


    @ApiOperation(value="노래 목록 API", notes="노래 목록 가져오기")
    @GetMapping("")
    public List<MusicDto> MusicList(){
        List<MusicDto> list = musicService.allMusic();
        return list;
    }

    @ApiOperation(value="노래 단일 정보 API", notes="단일 노래 정보 가져오기")
    @GetMapping("/{musicId}")
    public MusicDto musicInfoRequest(@PathVariable("musicId") Long musicId){
        MusicDto musicDto =musicService.getMusic(musicId);
        return musicDto;
    }
    @ApiOperation(value = "장르별 노래 검색 API", notes = "장르별 노래 검색")
    @GetMapping("/genre/{genre}")
    public ResponseEntity<?> musicBygenre(@PathVariable("genre") String genre){
        List<MusicDto> list = new ArrayList<>();
        try{
            list = musicService.findByGenre(genre);
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            log.info("Exception -> "+ e.toString());
            return new ResponseEntity<>(new ErrorVO(ErrorCodeEnum.ERROR_400), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/singer/{singerName}")
    public ResponseEntity<?> musicBySinger(@PathVariable("singerName") String singerName){
        log.info("singerName ->" + singerName);
        List<MusicDto> list = new ArrayList<>();
        try{
            list = musicService.findBySinger(singerName);
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            log.info("Exception -> "+ e.toString());
            return new ResponseEntity<>(new ErrorVO(ErrorCodeEnum.ERROR_400), HttpStatus.BAD_REQUEST);
        }
    }
}
