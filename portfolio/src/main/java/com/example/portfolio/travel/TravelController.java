package com.example.portfolio.travel;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/travel", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TravelController {

    private final TravelService service;



}
