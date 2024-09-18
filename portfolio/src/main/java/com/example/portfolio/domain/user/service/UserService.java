package com.example.portfolio.domain.user.service;

import com.example.portfolio.domain.user.dto.UserDto;
import com.example.portfolio.domain.user.dto.UserSignInDto;
import com.example.portfolio.domain.user.entity.AuthorityEntity;
import com.example.portfolio.domain.user.entity.UserAuthKey;
import com.example.portfolio.domain.user.entity.UserAutorityEntity;
import com.example.portfolio.domain.user.entity.UserEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
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
}
