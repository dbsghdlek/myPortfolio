package com.example.portfolio.domain.user;

import com.example.portfolio.config.jwt.JwtFilter;
import com.example.portfolio.config.jwt.TokenProvider;
import com.example.portfolio.domain.user.dto.LoginDto;
import com.example.portfolio.domain.user.dto.TokenDto;
import com.example.portfolio.domain.user.dto.UserDto;
import com.example.portfolio.domain.user.dto.UserSignInDto;
import com.example.portfolio.domain.user.service.UserService;
import com.example.portfolio.web.response.result.ResultCodeEnum;
import com.example.portfolio.web.response.result.ResultVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserService userService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({DuplicateKeyException.class})
    public ResponseEntity<ResultVo> illegalExHandle(Exception e){
        log.error("[ExceptionHandle] ex", e);
        return new ResponseEntity<>(new ResultVo(ResultCodeEnum.ERROR_400), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/signin")
    public ResponseEntity<UserDto> userSignIn(@RequestBody UserSignInDto userSignInDto){
        UserDto userDto = userService.userSignIn(userSignInDto);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> autorize(@Valid @RequestBody LoginDto loginDto){

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getLoginId(), loginDto.getPassword());

        //여기서 CustomUserDetailService에서 Orverride한 메소드가 실행됨.
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt );

        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/test")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity<String> authTest(Authentication authentication){
        authentication.getAuthorities().forEach(System.out::println);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
