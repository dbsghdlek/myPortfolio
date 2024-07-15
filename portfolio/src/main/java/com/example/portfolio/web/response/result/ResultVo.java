package com.example.portfolio.web.response.result;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
public class ResultVo {
    @NotEmpty
    private int code;

    private Object contents;

    @NotEmpty
    private String message;

    public ResultVo(ResultCodeEnum result){
        this.code = result.getCode();
        this.message = result.getDescription();
    }
}
