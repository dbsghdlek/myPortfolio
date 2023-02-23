package com.personal.portfolio.web.controller;

import com.personal.portfolio.domain.entity.MainMenus;
import com.personal.portfolio.domain.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MenuController {
    private final MenuRepository menuRepository;

    @GetMapping("/getMenus")
    public List<MainMenus> getMenus(){
        List<MainMenus> list = menuRepository.getMenuList();
        log.info("API 호출됨");
        return list;
    }
}
