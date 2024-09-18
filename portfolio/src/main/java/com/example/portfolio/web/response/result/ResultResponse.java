package com.example.portfolio.web.response.result;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public abstract class ResultResponse {
    
    //단일 객체 응답
    public static ResponseEntity<?> wrapperResult(Object contents) {
        if(contents != null){
            return new ResponseEntity<>(new ResultVo(ResultCodeEnum.SUCCESS_0000, contents), ResultCodeEnum.SUCCESS_0000.getHttpStatus());
        }else
            return new ResponseEntity<>(new ResultVo(ResultCodeEnum.ERROR_400), ResultCodeEnum.ERROR_400.getHttpStatus());
    }
    
    // 헤더 추가 응답
    public static ResponseEntity<?> wrapperResult(Object contents, HttpHeaders httpHeaders) {
        if(contents != null){
            return new ResponseEntity<>(new ResultVo(ResultCodeEnum.SUCCESS_0000, contents), httpHeaders, ResultCodeEnum.SUCCESS_0000.getHttpStatus());
        }else
            return new ResponseEntity<>(new ResultVo(ResultCodeEnum.ERROR_400), ResultCodeEnum.ERROR_400.getHttpStatus());
    }
    
    // Collection 객체 응답
    public static ResponseEntity<?> wrapperResult(Collection contents) {
        if(contents.size() != 0){
            return new ResponseEntity<>(new ResultVo(ResultCodeEnum.SUCCESS_0000, contents), ResultCodeEnum.SUCCESS_0000.getHttpStatus());
        }else
            return new ResponseEntity<>(new ResultVo(ResultCodeEnum.ERROR_3000), ResultCodeEnum.ERROR_3000.getHttpStatus());
    }

    public static ResponseEntity<?> wrapperResult(boolean result) {
        if (result){
            return new ResponseEntity<>(new ResultVo(ResultCodeEnum.SUCCESS_0000), ResultCodeEnum.SUCCESS_0000.getHttpStatus());
        }else
            return new ResponseEntity<>(new ResultVo(ResultCodeEnum.ERROR_400), ResultCodeEnum.ERROR_400.getHttpStatus());
    }
}
