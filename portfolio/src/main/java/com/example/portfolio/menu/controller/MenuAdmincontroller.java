package com.example.portfolio.menu.controller;

import com.example.portfolio.domain.controller.BaseController;
import com.example.portfolio.domain.result.ResponseResult;
import com.example.portfolio.domain.result.Result;
import com.example.portfolio.menu.MenuDto;
import com.example.portfolio.menu.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuAdmincontroller{

    private final MenuService menuService;

    @Operation(summary = "메뉴 업데이트 API", description = "메뉴 정보 업데이트")
    @PutMapping("/update/{menuId}")
    public ResponseEntity<?> updateMenu(@RequestBody MenuDto menuDto, @PathVariable Long menuId){
        menuDto.setMenuId(menuId);
        boolean response = menuService.updateMenu(menuDto);

        Result result = ResponseResult.wrapperResult(response);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(summary = "메뉴 삭제 API", description = "메뉴 정보 삭제")
    @DeleteMapping
    public ResponseEntity<?> deleteMenu(Long menuId){
        boolean response = menuService.deleteMenu(menuId);

        Result result = ResponseResult.wrapperResult(response);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
