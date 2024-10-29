package com.example.portfolio.config.jwt;

import com.example.portfolio.domain.user.dto.TokenDto;
import com.example.portfolio.domain.user.entity.UserEntity;
import com.example.portfolio.domain.user.service.UserRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class TokenProvider implements InitializingBean {

    private static final String AUTHORITIES_KEY = "auth";

    private final String secret;
    private final long tokenValidityInMilliseconds;
    private final RedisTemplate<String, String> redisTemplate;
    private final UserRepository userRepository;

    private Key key;

    public TokenProvider(@Value("${jwt.secret}") String secret,
                         @Value("${jwt.token-validity-in-seconds}") long tokenValidityInSeconds,
                         RedisTemplate redisTemplate,
                         UserRepository userRepository){
        this.secret = secret;
        this.tokenValidityInMilliseconds = tokenValidityInSeconds;
        this.redisTemplate = redisTemplate;
        this.userRepository = userRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        byte[] ketBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(ketBytes);
    }

    public TokenDto createToken(Authentication authentication){
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();
        //access 토큰 만료시간
        Date tokenExpiredTime = new Date(now + this.tokenValidityInMilliseconds);
        Date refreshtokenExpiredTime = new Date(now + (6000 * this.tokenValidityInMilliseconds));

        // accessToken 생성
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(key, SignatureAlgorithm.HS512) // 암복호화 알고리즘 설정
                .setExpiration(tokenExpiredTime) //만료시간 설정
                .compact();

        //RefreshToken 생성
        String refreshToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .setExpiration(refreshtokenExpiredTime)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

        return TokenDto.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshTokenExiprationTime(refreshtokenExpiredTime)
                .refreshToken(refreshToken)
                .build();
    }

    public  Authentication getAuthentication(String token){
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String token){
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }catch (SecurityException | MalformedJwtException e){
            log.info("잘못된 JWT 서명입니다.");
        }catch (ExpiredJwtException e){
            log.info("만료된 JWT 토큰입니다.");
        }catch (UnsupportedJwtException e){
            log.info("지원되지 않는 JWT 토큰입니다.");
        }catch (IllegalArgumentException e){
            log.info("잘못된 JWT 토큰입니다.");
        }
        return false;
    }

    public Claims parseClaims(String token){
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        }catch (ExpiredJwtException e){
            return e.getClaims();
        }
    }

    public boolean existRefreshToken(String refreshToken){
        String token = redisTemplate.opsForValue().get(refreshToken);
        return (token != null);
    }

    public void setHeaderAccessToken(HttpServletResponse response, String accessToken){
        response.setHeader("Authorization", new StringBuilder("bearer ").append(accessToken).toString());
    }

    public void setHeaderRefreshToken(HttpServletResponse response, String refreshToken){
        response.setHeader("Refresh", new StringBuilder("bearer ").append(refreshToken).toString());
    }
}
