package com.example.portfolio.travel.controller;

import com.example.portfolio.domain.controller.BaseController;
import com.example.portfolio.travel.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/travel", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TravelController extends BaseController {

    private final TravelService service;

}
