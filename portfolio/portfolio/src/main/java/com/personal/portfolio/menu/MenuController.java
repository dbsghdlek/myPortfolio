package com.personal.portfolio.menu;

import com.personal.portfolio.domain.result.ErrorResult;
import com.personal.portfolio.error.ErrorCode;
import com.personal.portfolio.error.ErrorVO;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

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
    @ApiOperation(value="메뉴 목록 API", notes="메뉴 목록 가져오기")
    @GetMapping("")
    public ResponseEntity<?> getMenus(){
        List<MenuDto> list = menuService.allMenuByJpa();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @ApiOperation(value = "메뉴 정보 가져오기", notes = "단일 메뉴 정보 가져오기")
    @GetMapping("/{menuId}")
    public ResponseEntity<?> getMenu(@PathVariable int menuId){
        MenuDto menu = menuService.getMenu(menuId);

        if(menu == null){
            return new ResponseEntity<>(new ErrorVO(ErrorCode.ERROR_3000), HttpStatus.OK);
        }

        return new ResponseEntity<>(menu, HttpStatus.OK);
    }
    @ApiOperation(value="메뉴 추가", notes = "메뉴 추가하기")
    @PutMapping("")
    public ResponseEntity<?> saveMenu(MenuDto menuDto){
        log.info("menuDto", menuDto);
        MenuEntity menuEntity = menuService.insertMenu(menuDto);
        log.info("menuEntity", menuEntity.toString());
        if(menuEntity == null){
            return new ResponseEntity<>(new ErrorVO(ErrorCode.SUCCESS_0000), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ErrorVO(ErrorCode.ERROR_4000), HttpStatus.BAD_REQUEST);
        }
    }

}
