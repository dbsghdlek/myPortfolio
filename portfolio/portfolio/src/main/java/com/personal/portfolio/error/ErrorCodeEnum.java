package com.personal.portfolio.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

//1000번대 권한관련 에러
//2000번대
//3000번대 데이터 관련
//4000번대 DB 에러
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    SUCCESS_0000(0000, "Success"),

    ERROR_400(400, "BAD Request"),
    ERROR_1000(1000,"Authorization Denied"),
    ERROR_2000(2000,""),
    ERROR_3000(3000,"Data Not Empty"),
    ERROR_4000(4000, "Save Failed"),
    ERROR_9999(9999, "Unknown error");

    private int errorCode;
    private String errorReason;
}
