package com.example.portfolio.keyboard;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/keyboard", produces = MediaType.APPLICATION_JSON_VALUE)
public class KeyboardContoller {

    private final KeyboardService service;


}
