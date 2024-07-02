package com.example.portfolio.menu;

import com.example.portfolio.domain.error.ResultCodeEnum;
import com.example.portfolio.domain.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuAdmincontroller {

    private final MenuService menuService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class, TypeMismatchException.class, SQLIntegrityConstraintViolationException.class})
    public Result illegalExHandle(Exception e){
        log.error("[ExceptionHandle] ex", e);
        return new Result(ResultCodeEnum.ERROR_400.getCode(), "message");
    }
    @ExceptionHandler({EmptyResultDataAccessException.class, NoSuchElementException.class})
    public Result dataExceptionHandler(Exception e){
        log.error("[ExceptionHandle] ex", e);
        return new Result(ResultCodeEnum.ERROR_400.getCode(), "DataNotEmpty");
    }

    @Operation(summary = "메뉴 업데이트 API", description = "메뉴 정보 업데이트")
    @PutMapping("/update/{menuId}")
    public ResponseEntity<?> updateMenu(@RequestBody MenuDto menuDto, @PathVariable Long menuId){
        menuDto.setMenuId(menuId);
        boolean response = menuService.updateMenu(menuDto);

        Result result;
        if(response){
            result = Result.builder()
                    .code(ResultCodeEnum.SUCCESS_0000.getCode())
                    .message(ResultCodeEnum.SUCCESS_0000.getReason())
                    .build();
        }else
            result = Result.builder()
                .code(ResultCodeEnum.ERROR_400.getCode())
                .message(ResultCodeEnum.ERROR_400.getReason())
                .build();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(summary = "메뉴 삭제 API", description = "메뉴 정보 삭제")
    @DeleteMapping
    public ResponseEntity<?> deleteMenu(Long menuId){
        boolean response = menuService.deleteMenu(menuId);

        Result result;
        if(response){
            result = Result.builder()
                    .code(ResultCodeEnum.SUCCESS_0000.getCode())
                    .message(ResultCodeEnum.SUCCESS_0000.getReason())
                    .build();
        }else
            result = Result.builder()
                    .code(ResultCodeEnum.ERROR_400.getCode())
                    .message(ResultCodeEnum.ERROR_400.getReason())
                    .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
