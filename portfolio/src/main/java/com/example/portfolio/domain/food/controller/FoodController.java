package com.example.portfolio.domain.food.controller;

import com.example.portfolio.domain.base.BaseController;
import com.example.portfolio.domain.food.FoodDto;
import com.example.portfolio.domain.food.FoodService;
import com.example.portfolio.web.response.result.ResultResponse;
import com.example.portfolio.web.response.result.ResultVo;
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


    @GetMapping("")
    public ResponseEntity foodList(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber){
        List<FoodDto> foodDtoList = service.getListByPaging(pageNumber);

        return ResultResponse.wrapperResult(foodDtoList);
    }
}
