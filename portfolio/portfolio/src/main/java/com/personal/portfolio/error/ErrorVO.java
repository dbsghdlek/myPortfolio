package com.personal.portfolio.error;

import lombok.Data;

@Data
public class ErrorVO {

    public ErrorVO(ErrorCode errorCode){
        this.errorCode = errorCode.getErrorCode();
        this.errorReason = errorCode.getErrorReason();
    }
    private int errorCode;
    private String errorReason;

}
