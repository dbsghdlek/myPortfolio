package com.personal.portfolio.singer;


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


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({TypeMismatchException.class})
    public ErrorResult typeMisMatchExceptionHandler(){
        return new ErrorResult("486", "TypeMisMatch");
    }

    @PostMapping("/add")
    public ErrorResult singerAdd(@RequestBody SingerDto singerDto){
        log.info("singerInfo :", singerDto);
        return  new ErrorResult("200", "ok");
    }
}
