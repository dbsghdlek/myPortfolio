package com.example.portfolio.domain.food.controller;

import com.example.portfolio.domain.base.BaseController;
import com.example.portfolio.domain.food.dto.FoodDto;
import com.example.portfolio.domain.food.service.FoodService;
import com.example.portfolio.web.response.result.ResultResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/food", produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodController extends BaseController{

    private final FoodService service;

    @Operation(summary = "음식 사진 가져오기 API", description = "음식 사진 가져오기")
    @GetMapping("/list/{pageNumber}")
    public ResponseEntity foodList(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber){
        List<FoodDto> foodDtoList = service.getListByPaging(pageNumber);

        return ResultResponse.wrapperResult(foodDtoList);
    }

}
