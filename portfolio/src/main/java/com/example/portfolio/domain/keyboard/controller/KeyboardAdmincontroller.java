package com.example.portfolio.domain.keyboard.controller;

import com.example.portfolio.domain.base.BaseController;
import com.example.portfolio.domain.keyboard.service.KeyboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin/keyboard", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class KeyboardAdmincontroller extends BaseController{

    private final KeyboardService service;

}
