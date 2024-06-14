package com.example.portfolio.domain.result;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ErrorResult {
    @NotEmpty
    private String code;
    @NotEmpty
    private String message;
}
