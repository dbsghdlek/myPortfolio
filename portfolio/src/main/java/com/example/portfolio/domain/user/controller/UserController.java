package com.example.portfolio.domain.user.controller;

import com.example.portfolio.config.jwt.JwtFilter;
import com.example.portfolio.domain.user.dto.LoginDto;
import com.example.portfolio.domain.user.dto.TokenDto;
import com.example.portfolio.domain.user.dto.UserDto;
import com.example.portfolio.domain.user.dto.UserSignInDto;
import com.example.portfolio.domain.user.service.UserService;
import com.example.portfolio.web.response.result.ResultCodeEnum;
import com.example.portfolio.web.response.result.ResultResponse;
import com.example.portfolio.web.response.result.ResultVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({DuplicateKeyException.class})
    public ResponseEntity<ResultVo> illegalExHandle(Exception e){
        log.error("[ExceptionHandle] ex", e);
        return new ResponseEntity<>(new ResultVo(ResultCodeEnum.ERROR_400), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> userSignIn(@RequestBody UserSignInDto userSignInDto){
        UserDto userDto = userService.userSignIn(userSignInDto);

        return ResultResponse.wrapperResult(userDto);
    }

    @Operation(summary = "회원 가입 요청", description = "회원 정보가 등록됩니다.", tags = { "Member Controller" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@Valid @RequestBody LoginDto loginDto){

        TokenDto token = userService.login(loginDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, new StringBuilder("Bearer ").append(token.getAccessToken()).toString());
        httpHeaders.add(JwtFilter.REFRESH_HEADER, new StringBuilder("Bearer ").append(token.getRefreshToken()).toString());

        return ResultResponse.wrapperResult(token, httpHeaders);
    }

    @GetMapping("/access-token/refresh")
    public ResponseEntity<?> accessTokenRefresh(@RequestHeader(JwtFilter.REFRESH_HEADER) String refreshToken){
        userService.accessTokenRefresh(refreshToken);
        return ResultResponse.wrapperResult(true);
    }
}
