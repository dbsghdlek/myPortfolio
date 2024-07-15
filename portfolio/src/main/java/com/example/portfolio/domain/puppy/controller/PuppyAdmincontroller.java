package com.example.portfolio.domain.puppy.controller;

import com.example.portfolio.domain.base.BaseController;
import com.example.portfolio.domain.puppy.PuppyDto;
import com.example.portfolio.domain.puppy.PuppyService;
import com.example.portfolio.web.response.result.ResultResponse;
import com.example.portfolio.web.response.result.ResultVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin/puppy", produces = MediaType.APPLICATION_JSON_VALUE)
public class PuppyAdmincontroller extends BaseController{

    private final PuppyService service;

    @Operation(summary = "강아지 사진 등록", description = "강아지 사진을 등록하는 API")
    @PostMapping("/")
    public ResponseEntity<?> insertPuppy(PuppyDto dto){
        boolean result = service.addPicture(dto);

        return ResultResponse.wrapperResult(result);
    }


}
