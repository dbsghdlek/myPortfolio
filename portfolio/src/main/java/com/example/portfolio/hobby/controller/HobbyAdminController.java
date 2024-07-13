package com.example.portfolio.hobby.controller;

import com.example.portfolio.domain.controller.BaseController;
import com.example.portfolio.domain.result.ResponseResult;
import com.example.portfolio.hobby.HobbyDto;
import com.example.portfolio.hobby.HobbyService;
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

        return new ResponseEntity<>(ResponseResult.wrapperResult(result), HttpStatus.OK );
    }
}
