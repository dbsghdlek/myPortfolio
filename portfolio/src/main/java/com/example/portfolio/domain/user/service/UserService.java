package com.example.portfolio.domain.user.service;

import com.example.portfolio.config.jwt.TokenProvider;
import com.example.portfolio.domain.user.dto.LoginDto;
import com.example.portfolio.domain.user.dto.TokenDto;
import com.example.portfolio.domain.user.dto.UserDto;
import com.example.portfolio.domain.user.dto.UserSignInDto;
import com.example.portfolio.domain.user.entity.AuthorityEntity;
import com.example.portfolio.domain.user.entity.UserAuthKey;
import com.example.portfolio.domain.user.entity.UserAutorityEntity;
import com.example.portfolio.domain.user.entity.UserEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserAuthRepository userAuthRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final RedisTemplate<String, Object> redisTemplate;

    @Transactional
    public UserDto userSignIn(UserSignInDto userDto){
        if(userRepository.searchLoginIdDuplicated(userDto.getLoginId())){
            throw new DuplicateKeyException("이미 존재하는 ID입니다.");
        }

        UserEntity userEntity = UserEntity.builder()
                .loginid(userDto.getLoginId())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .username(userDto.getUserName())
                .authorities(new HashSet<UserAutorityEntity>())
                .activated(true)
                .build();

        // Role_USER 권한을 select하여 영속성 컨텍스트에 등록
        AuthorityEntity authority = authorityRepository.getUserAuthority();

        UserAutorityEntity userAuth = UserAutorityEntity.builder()
                .user(userEntity)
                .authority(authority)
                .userAuthKey(new UserAuthKey(userEntity.getId(), authority.getAuthorityName()))
                .build();

        UserAutorityEntity saveUser = userAuthRepository.save(userAuth);

        return UserDto.builder().loginId(saveUser.getUser().getLoginid()).userName(saveUser.getUser().getUsername()).build();
    }

    public TokenDto login(LoginDto loginDto){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getLoginId(), loginDto.getPassword());

        //여기서 CustomUserDetailService에서 Orverride한 메소드가 실행됨.
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        TokenDto token = tokenProvider.createToken(authentication);

        
        // redis RepreshToken 저장 및 TTL 지정
        redisTemplate.opsForValue().set(token.getRefreshToken(), token.getAccessToken());
        String refreshTokenExipredDate = tokenProvider.parseClaims(token.getRefreshToken()).get("exp").toString();
        redisTemplate.expireAt(token.getRefreshToken(), new Date(refreshTokenExipredDate));

        return token;
    }
}
