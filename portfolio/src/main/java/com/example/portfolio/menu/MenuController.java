package com.example.portfolio.menu;

import com.example.portfolio.domain.result.ErrorResult;
import com.example.portfolio.domain.error.ErrorCodeEnum;
import com.example.portfolio.domain.error.ErrorVO;
import com.querydsl.jpa.impl.JPAQueryFactory;
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
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController {

    private final MenuService menuService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class, TypeMismatchException.class, SQLIntegrityConstraintViolationException.class})
    public ErrorResult illegalExHandle(Exception e){
        log.error("[ExceptionHandle] ex", e);
        return new ErrorResult("BAD", "message");
    }
    @ExceptionHandler({EmptyResultDataAccessException.class, NoSuchElementException.class})
    public ErrorResult dataExceptionHandler(Exception e){
        log.error("[ExceptionHandle] ex", e);
        return new ErrorResult("BAD", "DataNotEmpty");
    }

    @Operation(summary="메뉴 목록 API", description="메뉴 목록 가져오기")
    @GetMapping("")
    public ResponseEntity<?> getMenus(){
        List<MenuDto> list = menuService.allMenuByJpa();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    @Operation(summary = "메뉴 정보 가져오기", description = "단일 메뉴 정보 가져오기")
//    @GetMapping("/{menuId}")
//    public ResponseEntity<?> getMenu(@PathVariable Long menuId){
//        MenuDto menu = menuService.getMenu(menuId);
//
//        if(menu == null){
//            return new ResponseEntity<>(new ErrorVO(ErrorCodeEnum.ERROR_3000), HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>(menu, HttpStatus.OK);
//    }
}
