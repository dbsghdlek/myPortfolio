package com.example.portfolio.domain.controller;

import com.example.portfolio.domain.error.ResultCodeEnum;
import com.example.portfolio.domain.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@Slf4j
public abstract class BaseController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class, TypeMismatchException.class, SQLIntegrityConstraintViolationException.class})
    public Result illegalExHandle(Exception e){
        log.error("[ExceptionHandle] ex", e);
        return new Result(ResultCodeEnum.ERROR_400.getCode(), "message");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EmptyResultDataAccessException.class, NoSuchElementException.class})
    public Result dataExceptionHandler(Exception e) {
        log.error("[ExceptionHandle] ex", e);
        return new Result(ResultCodeEnum.ERROR_400.getCode(), "DataNotEmpty");
    }
}
