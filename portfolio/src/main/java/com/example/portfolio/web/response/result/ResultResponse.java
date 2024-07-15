package com.example.portfolio.web.response.result;



public abstract class ResponseResult {
    public static ResultCodeEnum wrapperResult(Object contents) {
        if (contents != null ){
            return ResultCodeEnum.SUCCESS_0000;
        }else return ResultCodeEnum.ERROR_400;
    }

    public static ResultCodeEnum wrapperResult(boolean contents) {
        if (contents){
            return ResultCodeEnum.SUCCESS_0000;
        }else return ResultCodeEnum.ERROR_400;
    }
}
