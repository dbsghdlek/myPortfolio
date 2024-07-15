package com.example.portfolio.web.response.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//1000번대 권한관련 에러
//2000번대
//3000번대 데이터 관련
//4000번대 DB 에러
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {
    SUCCESS_0000(0000, "Success", HttpStatus.OK),
    ERROR_400(400, "BAD Request", HttpStatus.BAD_REQUEST),
    ERROR_1000(1000,"Authorization Denied", HttpStatus.UNAUTHORIZED),
    ERROR_3000(3000,"Data Not Empty", HttpStatus.NOT_FOUND),
    ERROR_4000(4000, "Save Failed", HttpStatus.GATEWAY_TIMEOUT),
    ERROR_9999(9999, "Unknown error", HttpStatus.NOT_FOUND);

    private int code;
    private String description;
    private HttpStatus httpStatus;
}
