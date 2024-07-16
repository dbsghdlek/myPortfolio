package com.example.portfolio.web.response.result;


import org.springframework.http.ResponseEntity;

import java.util.Collection;

public abstract class ResultResponse {

    public static ResponseEntity<?> wrapperResult(Object contents) {
        if(contents != null){
            return new ResponseEntity<>(new ResultVo(ResultCodeEnum.SUCCESS_0000, contents), ResultCodeEnum.SUCCESS_0000.getHttpStatus());
        }else
            return new ResponseEntity<>(new ResultVo(ResultCodeEnum.ERROR_400), ResultCodeEnum.ERROR_400.getHttpStatus());
    }

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
