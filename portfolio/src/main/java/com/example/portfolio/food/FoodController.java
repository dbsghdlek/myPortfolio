package com.example.portfolio.food;

import com.example.portfolio.domain.error.ResultCodeEnum;
import com.example.portfolio.domain.result.Result;
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
@RequestMapping(value = "/food", produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodController {

    private final FoodService service;

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

    @GetMapping("")
    public ResponseEntity<?> foodList(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber){
        List<FoodDto> foodDtoList = service.foodList(pageNumber);

        return new ResponseEntity<>(foodDtoList, HttpStatus.OK);
    }
}
