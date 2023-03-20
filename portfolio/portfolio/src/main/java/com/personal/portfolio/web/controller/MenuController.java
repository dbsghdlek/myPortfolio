package com.personal.portfolio.web.controller;

import com.personal.portfolio.domain.entity.MenuEntity;
import com.personal.portfolio.domain.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MenuController {
    private final MenuRepository menuRepository;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandle(IllegalArgumentException e){
        log.error("[ExceptionHandle] ex", e);
        return new ErrorResult("BAD", "message");
    }
    @GetMapping("/Menus")
    public List<MenuEntity> getMenus(){
        List<MenuEntity> list = menuRepository.getMenuList();
        log.info("API 호출됨");
        return list;
    }
}
