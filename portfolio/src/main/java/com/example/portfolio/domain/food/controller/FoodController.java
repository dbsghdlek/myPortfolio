package com.example.portfolio.food.controller;

import com.example.portfolio.domain.base.controller.BaseController;
import com.example.portfolio.domain.result.ResponseResult;
import com.example.portfolio.domain.result.Result;
import com.example.portfolio.food.FoodDto;
import com.example.portfolio.food.FoodService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/food", produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodController extends BaseController{

    private final FoodService service;



    @GetMapping("")
    public Result foodList(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber){
        List<FoodDto> foodDtoList = service.getListByPaging(pageNumber);

        return ResponseResult.wrapperResult(foodDtoList);
    }
}
