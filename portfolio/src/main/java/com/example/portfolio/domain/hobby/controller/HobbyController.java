package com.example.portfolio.domain.hobby.controller;

import com.example.portfolio.domain.base.BaseController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hobby", produces = MediaType.APPLICATION_JSON_VALUE)
public class HobbyController extends BaseController{

}
