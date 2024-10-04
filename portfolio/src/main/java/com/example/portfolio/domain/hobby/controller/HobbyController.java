package com.example.portfolio.domain.hobby.controller;

import com.example.portfolio.domain.base.BaseController;
import com.example.portfolio.domain.hobby.HobbyDto;
import com.example.portfolio.domain.hobby.service.HobbyService;
import com.example.portfolio.web.response.result.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/hobby", produces = MediaType.APPLICATION_JSON_VALUE)
public class HobbyController extends BaseController{

    private final HobbyService service;

    @GetMapping("/list/{pageNumber}")
    public ResponseEntity<?> getHobbyList(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber){
        List<HobbyDto> hobbyList = service.allHobby(pageNumber);

        return ResultResponse.wrapperResult(hobbyList);
    }
}
