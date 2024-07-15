package com.example.portfolio.puppy.controller;

import com.example.portfolio.domain.base.controller.BaseController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin/puppy", produces = MediaType.APPLICATION_JSON_VALUE)
public class PuppyAdmincontroller extends BaseController{
}
