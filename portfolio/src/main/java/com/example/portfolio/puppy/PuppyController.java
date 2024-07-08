package com.example.portfolio.puppy;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/puppy", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PuppyController {

    private final PuppyService service;


}
