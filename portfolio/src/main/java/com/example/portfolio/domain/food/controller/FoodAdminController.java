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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin/food", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class FoodAdminController  extends BaseController{

    private final FoodService foodService;

    @Operation(summary = "음식 사진 등록 API", description = "음식 사진 등록")
    @PostMapping("")
    public ResponseEntity<?> insertFood(@RequestBody FoodDto foodDto){

        return ResultResponse.wrapperResult(foodService.insertFood(foodDto));
    }

    @Operation(summary = "음식 사진 업데이트 API", description = "음식 사진 업데이트")
    @PutMapping("/{foodId}")
    public ResponseEntity<?> updateFood(@PathVariable Long foodId, @RequestBody FoodDto foodDto){
        foodDto.setId(foodId);

        return ResultResponse.wrapperResult(foodService.updateFood(foodDto));
    }

    @Operation(summary = "음식 사진 삭제 API", description = "음식 사진 삭제")
    @DeleteMapping("/{foodId}")
    public ResponseEntity<?> deleteFood(@PathVariable Long foodId){

        return ResultResponse.wrapperResult(foodService.deleteFood(foodId));
    }
}
