package com.personal.portfolio.menu;

import com.personal.portfolio.domain.result.ErrorResult;
import com.personal.portfolio.error.ErrorCode;
import com.personal.portfolio.error.ErrorVO;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value="메뉴 목록 API", notes="메뉴 목록 가져오기")
    @GetMapping("")
    public ResponseEntity<?> getMenus(){
        List<MenuDto> list = menuService.allMenuByJpa();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @ApiOperation(value = "메뉴 정보 가져오기", notes = "단일 메뉴 정보 가져오기")
    @GetMapping("/{menuId}")
    public ResponseEntity<?> getMenu(@PathVariable Long menuId){
        MenuDto menu = menuService.getMenu(menuId);

        if(menu == null){
            return new ResponseEntity<>(new ErrorVO(ErrorCode.ERROR_3000), HttpStatus.OK);
        }

        return new ResponseEntity<>(menu, HttpStatus.OK);
    }
    @GetMapping("/querydsl/{menuId}")
    public ResponseEntity<?> getMenuUsingQueryDsl(@PathVariable Long menuId){
        MenuDto menu = menuService.getMenuUsingQueryDsl(menuId);

        if(menu == null){
            return new ResponseEntity<>(new ErrorVO(ErrorCode.ERROR_3000), HttpStatus.OK);
        }

        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @ApiOperation(value="메뉴 추가", notes = "메뉴 추가하기")
    @PostMapping("/")
    public ResponseEntity<?> saveMenu(MenuDto menuDto){
        if(menuService.insertMenu(menuDto)){
            return new ResponseEntity<>(new ErrorVO(ErrorCode.SUCCESS_0000), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ErrorVO(ErrorCode.ERROR_4000), HttpStatus.BAD_REQUEST);
        }
    }
    @ApiOperation(value = "메뉴 수정하기", notes = "메뉴 수정하기")
    @PutMapping("/")
    public ResponseEntity<?> updateMenu(MenuDto menuDto){
        if(menuService.updateMenu(menuDto)){
            return new ResponseEntity<>(new ErrorVO(ErrorCode.SUCCESS_0000), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ErrorVO(ErrorCode.ERROR_4000), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "메뉴 삭제", notes = "메뉴 삭제하기")
    @DeleteMapping("/{menuId}")
    public ResponseEntity<?> removeMenu(@PathVariable Long menuId){
        if(menuService.deleteMenu(menuId)){
            return new ResponseEntity<>(new ErrorVO(ErrorCode.SUCCESS_0000), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ErrorVO(ErrorCode.ERROR_4000), HttpStatus.BAD_REQUEST);
        }
    }
}
