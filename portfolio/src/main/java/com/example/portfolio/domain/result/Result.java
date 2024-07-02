package com.example.portfolio.domain.result;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class Result {
    @NotEmpty
    private int code;

    private Object contents;

    @NotEmpty
    private String message;

    public Result(int code, String message){
        this.code = code;
        this.message = message;
    }
}
