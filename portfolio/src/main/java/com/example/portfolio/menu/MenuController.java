package com.example.portfolio.menu;

import com.example.portfolio.domain.result.ResponseResult;
import com.example.portfolio.domain.result.Result;
import com.example.portfolio.domain.error.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController {

    private final MenuService service;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class, TypeMismatchException.class, SQLIntegrityConstraintViolationException.class})
    public Result illegalExHandle(Exception e){
        log.error("[ExceptionHandle] ex", e);
        return new Result(ResultCodeEnum.ERROR_400.getCode(), "message");
    }
    @ExceptionHandler({EmptyResultDataAccessException.class, NoSuchElementException.class})
    public Result dataExceptionHandler(Exception e){
        log.error("[ExceptionHandle] ex", e);
        return new Result(ResultCodeEnum.ERROR_400.getCode(), "DataNotEmpty");
    }

    @Operation(summary="메뉴 목록 API", description="메뉴 목록 가져오기")
    @GetMapping("")
    public ResponseEntity<?> getMenus(){
        List<MenuDto> list= service.allMenuByJpa();

        Result result = ResponseResult.wrapperResult(list);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
