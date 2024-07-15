package com.example.portfolio.domain.menu.controller;

import com.example.portfolio.domain.base.BaseController;
import com.example.portfolio.domain.menu.MenuService;
import com.example.portfolio.web.response.result.ResultResponse;
import com.example.portfolio.domain.menu.MenuDto;
import com.example.portfolio.web.response.result.ResultVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController extends BaseController{

    private final MenuService service;

    @Operation(summary="메뉴 목록 API", description="메뉴 목록 가져오기")
    @GetMapping("")
    public ResponseEntity<?> getMenus(){
        List<MenuDto> list= service.allMenuByJpa();

        return ResultResponse.wrapperResult(list);
    }
}
