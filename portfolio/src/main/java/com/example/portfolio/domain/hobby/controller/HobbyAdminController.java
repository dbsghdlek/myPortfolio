package com.example.portfolio.domain.hobby.controller;

import com.example.portfolio.domain.base.BaseController;
import com.example.portfolio.domain.hobby.HobbyDto;
import com.example.portfolio.web.response.result.ResultResponse;
import com.example.portfolio.domain.hobby.HobbyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin/hobby", produces = MediaType.APPLICATION_JSON_VALUE)
public class HobbyAdminController extends BaseController{

    private final HobbyService service;

    @PostMapping("/")
    public ResponseEntity<?> inputHobby(@RequestBody HobbyDto hobbyDto){
        boolean result = service.insert(hobbyDto);

        return ResultResponse.wrapperResult(result);
    }
}