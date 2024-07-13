package com.example.portfolio.hobby.controller;

import com.example.portfolio.domain.controller.BaseController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hobby", produces = MediaType.APPLICATION_JSON_VALUE)
public class HobbyController extends BaseController{

}
