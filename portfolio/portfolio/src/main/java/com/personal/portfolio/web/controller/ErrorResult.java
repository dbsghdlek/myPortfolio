package com.personal.portfolio.web.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class ErrorResult {
    @NotEmpty
    private String code;
    @NotEmpty
    private String message;
}
