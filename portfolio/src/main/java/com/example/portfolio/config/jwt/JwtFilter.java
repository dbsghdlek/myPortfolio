package com.example.portfolio.config.jwt;

import com.example.portfolio.domain.user.dto.TokenDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
@Slf4j
public class JwtFilter extends GenericFilterBean {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String REFRESH_HEADER = "Refresh";

    private final TokenProvider tokenProvider;

    public JwtFilter(TokenProvider tokenProvider){
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String accessToken = resolveAccessToken(httpServletRequest);
        String refreshToken = resolveRefreshToken(httpServletRequest);
        String requestURI = httpServletRequest.getRequestURI();

        // Access토큰과 Refresh 토큰이 있는지 확인
        if(accessToken != null){
            // token 검증
            if(tokenProvider.validateToken(accessToken)){
                Authentication authentication = tokenProvider.getAuthentication(accessToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                log.debug("Security Context에 '{}' 인증 정보를 저장했습니다. uri: {}", authentication.getName(), requestURI);
            } // AccessToken 만료, RefreshToken이 존재하는 경우
            else if (!tokenProvider.validateToken(accessToken) && refreshToken != null ) {
                // RefrsehyToken 만료 및 Redis에 존재하는지 확인
                System.out.println("Access토큰이 만료되어 RefreshToken을 사용하여 재발급");
                if(tokenProvider.validateToken(refreshToken) && tokenProvider.existRefreshToken(refreshToken)){
                    Authentication authentication = tokenProvider.getAuthentication(refreshToken);
                    TokenDto newTokenDto = tokenProvider.createToken(authentication);
                    tokenProvider.setHeaderAccessToken(httpServletResponse, newTokenDto.getAccessToken());
                    tokenProvider.setHeaderRefreshToken(httpServletResponse, newTokenDto.getRefreshToken());
                }
            } else{
                log.debug("유효한 JWT 토큰이 없습니다, uri: {}", requestURI);
            }
        } else{
            log.debug("유효한 JWT 토큰이 없습니다, uri: {}", requestURI);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    // Header에서 Access토큰 취득
    private String resolveAccessToken(HttpServletRequest request){
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return  bearerToken.substring(7);
        }
        return null;
    }

    // Header에서 Refresh토큰 취득
    private String resolveRefreshToken(HttpServletRequest request){
        String bearerToken = request.getHeader(REFRESH_HEADER);
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return  bearerToken.substring(7);
        }
        return null;
    }


}
