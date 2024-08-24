package com.example.portfolio.domain.user;

import com.example.portfolio.config.jwt.JwtFilter;
import com.example.portfolio.config.jwt.TokenProvider;
import com.example.portfolio.domain.user.dto.LoginDto;
import com.example.portfolio.domain.user.dto.TokenDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/authenticate")
    public ResponseEntity<TokenDto> autorize(@Valid @RequestBody LoginDto loginDto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getLoginId(), loginDto.getPassWd());

        //여기서 CustomUserDetailService에서 Orverride한 메소드가 실행됨.
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt );

        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }
}
