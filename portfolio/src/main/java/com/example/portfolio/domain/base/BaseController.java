package com.example.portfolio.domain.base;

import com.example.portfolio.web.response.result.ResultCodeEnum;
import com.example.portfolio.web.response.result.ResultVo;
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
    public ResultVo illegalExHandle(Exception e){
        log.error("[ExceptionHandle] ex", e);
        return new ResultVo(ResultCodeEnum.ERROR_400);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResultVo dataExceptionHandler(Exception e) {
        log.error("[ExceptionHandle] ex", e);
        return new ResultVo(ResultCodeEnum.ERROR_400);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoSuchElementException.class})
    public ResultVo noDataExceptionHandler(Exception e) {
        log.error("[ExceptionHandle] ex", e);
        return new ResultVo(ResultCodeEnum.ERROR_3000);
    }
}
