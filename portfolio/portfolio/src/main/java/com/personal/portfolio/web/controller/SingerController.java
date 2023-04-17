package com.personal.portfolio.web.controller;


import com.personal.portfolio.web.dto.Singer;
import com.personal.portfolio.domain.repository.SingerRepository;
import com.personal.portfolio.domain.result.ErrorResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping(value = "/singer", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SingerController {

    private final SingerRepository singerRepository;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({TypeMismatchException.class})
    public ErrorResult typeMisMatchExceptionHandler(){
        return new ErrorResult("486", "TypeMisMatch");
    }

    @PostMapping("/add")
    public ErrorResult singerAdd(@RequestBody Singer singer){
        log.info("singerInfo :", singer);
        singerRepository.inputSinger(singer);
        return  new ErrorResult("200", "ok");
    }
}
