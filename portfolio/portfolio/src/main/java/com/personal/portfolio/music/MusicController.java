package com.personal.portfolio.music;

import com.personal.portfolio.error.ErrorCode;
import com.personal.portfolio.error.ErrorVO;
import io.swagger.annotations.ApiOperation;
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
public class MusicController {
    public final MusicRepository musicRepository;

    public final MusicService musicService;

    @ApiOperation(value="노래 목록 API", notes="노래 목록 가져오기")
    @GetMapping("")
    public List<MusicDto> MusicList(){
        List<MusicDto> list = musicService.allMusic();
        return list;
    }

    @ApiOperation(value="노래 찾기 API", notes="노래 정보 가져오기")
    @GetMapping("/{musicId}")
    public MusicDto musicInfoRequest(@PathVariable("musicId") int musicId){
        MusicDto musicDto =musicService.getMusic(musicId);
        return musicDto;
    }
    @ApiOperation(value = "노래 추가 API", notes = "노래 추가하기")
    @PostMapping("/")
    public ResponseEntity<?> saveMusic(MusicDto musicDto){
        if(musicService.insertMusic(musicDto)){
            return new ResponseEntity<>(new ErrorVO(ErrorCode.SUCCESS_0000), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ErrorVO(ErrorCode.ERROR_4000), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "음원 정보 수정 API", notes = "음원 정보 수정하기")
    @PutMapping("/")
    public ResponseEntity<?> updateMusic(MusicDto musicDto){
        if(musicService.updateMusic(musicDto)){
            return new ResponseEntity<>(new ErrorVO(ErrorCode.SUCCESS_0000), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ErrorVO(ErrorCode.ERROR_4000), HttpStatus.BAD_REQUEST);
        }
    }
    @ApiOperation(value = "음원 삭제 API", notes = "음원 삭제하기")
    @DeleteMapping("/{musicId}")
    public ResponseEntity<?> deleteMusic(@PathVariable int musicId){
        if(musicService.deleteMusic(musicId)){
            return new ResponseEntity<>(new ErrorVO(ErrorCode.SUCCESS_0000), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ErrorVO(ErrorCode.ERROR_4000), HttpStatus.BAD_REQUEST);
        }
    }
}
