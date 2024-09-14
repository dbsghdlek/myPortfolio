package com.example.portfolio.domain.menu.controller;

import com.example.portfolio.domain.base.BaseController;
import com.example.portfolio.domain.menu.MenuDto;
import com.example.portfolio.domain.menu.MenuService;
import com.example.portfolio.web.response.result.ResultResponse;
import com.example.portfolio.web.response.result.ResultVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin/menu", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class MenuAdmincontroller extends BaseController{

    private final MenuService menuService;

    @Operation(summary = "메뉴 업데이트 API", description = "메뉴 정보 업데이트")
    @PutMapping("/update/{menuId}")
    public ResponseEntity<?> updateMenu(@RequestBody MenuDto menuDto, @PathVariable Long menuId){
        menuDto.setMenuId(menuId);
        boolean response = menuService.updateMenu(menuDto);

        return ResultResponse.wrapperResult(response);
    }

    @Operation(summary = "메뉴 삭제 API", description = "메뉴 정보 삭제")
    @DeleteMapping
    public ResponseEntity<?> deleteMenu(Long menuId){
        menuService.deleteMenu(menuId);
        return ResultResponse.wrapperResult(true);
    }
}
