package com.example.portfolio.music.controller;

import com.example.portfolio.domain.controller.BaseController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin/music", produces = MediaType.APPLICATION_JSON_VALUE)
public class MusicAdminController {
}
