package com.example.portfolio.domain.result;

import com.example.portfolio.domain.error.ResultCodeEnum;

import java.util.List;


public abstract class ResponseResult {
    public static Result wrapperResult(Object contents) {
        Result result;

        if (contents != null ){
            result = Result.builder()
                    .code(ResultCodeEnum.SUCCESS_0000.getCode())
                    .contents(contents)
                    .message(ResultCodeEnum.SUCCESS_0000.getReason())
                    .build();
        }else result = Result.builder()
                .code(ResultCodeEnum.ERROR_400.getCode())
                .message(ResultCodeEnum.ERROR_400.getReason())
                .build();
        return result;
    }

    public static Result wrapperResult(boolean contents) {
        Result result;

        if (contents){
            result = Result.builder()
                    .code(ResultCodeEnum.SUCCESS_0000.getCode())
                    .message(ResultCodeEnum.SUCCESS_0000.getReason())
                    .build();
        }else result = Result.builder()
                .code(ResultCodeEnum.ERROR_400.getCode())
                .message(ResultCodeEnum.ERROR_400.getReason())
                .build();
        return result;
    }


}
