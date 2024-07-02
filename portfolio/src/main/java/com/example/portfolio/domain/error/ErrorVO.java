package com.example.portfolio.domain.error;

import lombok.Data;

@Data
public class ErrorVO {

    public ErrorVO(ResultCodeEnum resultCodeEnum){
        this.errorCode = resultCodeEnum.getCode();
        this.errorReason = resultCodeEnum.getReason();
    }
    private int errorCode;
    private String errorReason;

}
