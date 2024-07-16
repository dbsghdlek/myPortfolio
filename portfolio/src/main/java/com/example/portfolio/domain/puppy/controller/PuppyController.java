package com.example.portfolio.domain.puppy.controller;

import com.example.portfolio.domain.base.BaseController;
import com.example.portfolio.domain.puppy.PuppyService;
import com.example.portfolio.web.response.result.ResultResponse;

import com.example.portfolio.web.response.result.ResultVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/puppy", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PuppyController extends BaseController {

    private final PuppyService service;

    @GetMapping("/{puppyName}/{pageNumber}")
    public ResponseEntity<?> searchByPuppyName(@PathVariable String puppyName, @PathVariable int pageNumber){
        return ResultResponse.wrapperResult(service.searchPuppyName(puppyName, pageNumber));
    }
}
