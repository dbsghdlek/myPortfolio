package com.example.portfolio.keyboard.controller;

import com.example.portfolio.domain.base.controller.BaseController;
import com.example.portfolio.keyboard.KeyboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/keyboard", produces = MediaType.APPLICATION_JSON_VALUE)
public class KeyboardContoller extends BaseController{

    private final KeyboardService service;


}
