package com.example.portfolio.domain.user.controller;

import com.example.portfolio.config.jwt.JwtFilter;
import com.example.portfolio.config.jwt.TokenProvider;
import com.example.portfolio.domain.user.dto.LoginDto;
import com.example.portfolio.domain.user.dto.TokenDto;
import com.example.portfolio.domain.user.dto.UserDto;
import com.example.portfolio.domain.user.dto.UserSignInDto;
import com.example.portfolio.domain.user.service.UserService;
import com.example.portfolio.web.response.result.ResultCodeEnum;
import com.example.portfolio.web.response.result.ResultResponse;
import com.example.portfolio.web.response.result.ResultVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/login")
    public ResponseEntity<?> autorize(@Valid @RequestBody LoginDto loginDto){

        TokenDto token = userService.login(loginDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + token.getAccessToken());

        return ResultResponse.wrapperResult(token, httpHeaders);
    }
}
