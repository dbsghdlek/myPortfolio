package com.example.portfolio.puppy.controller;

import com.example.portfolio.domain.base.controller.BaseController;
import com.example.portfolio.puppy.PuppyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/puppy", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PuppyController extends BaseController {

    private final PuppyService service;


}
