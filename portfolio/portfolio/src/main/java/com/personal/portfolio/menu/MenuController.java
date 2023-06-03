package com.personal.portfolio.menu;

import com.personal.portfolio.domain.result.ErrorResult;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController {

    private final MenuService menuService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class, TypeMismatchException.class})
    public ErrorResult illegalExHandle(IllegalArgumentException e){
        log.error("[ExceptionHandle] ex", e);
        return new ErrorResult("BAD", "message");
    }
    @ApiOperation(value="메뉴 목록 API", notes="메뉴 목록 가져오기")
    @GetMapping("/list")
    public ResponseEntity<Object> getMenus(){
        List<MenuDto> list = menuService.allMenuByJpa();

        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<Object> getMenu(@PathVariable int menuId){
        MenuDto menu = menuService.getMenu(menuId);
        return new ResponseEntity<Object>(menu, HttpStatus.OK);
    }

}
