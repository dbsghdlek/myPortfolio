package com.example.portfolio.domain.error;

import lombok.Data;

@Data
public class ErrorVO {

    public ErrorVO(ErrorCodeEnum errorCodeEnum){
        this.errorCode = errorCodeEnum.getErrorCode();
        this.errorReason = errorCodeEnum.getErrorReason();
    }
    private int errorCode;
    private String errorReason;

}
