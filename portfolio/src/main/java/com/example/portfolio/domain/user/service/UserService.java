package com.example.portfolio.domain.user.service;

import com.example.portfolio.domain.user.dto.UserDto;
import com.example.portfolio.domain.user.dto.UserSignInDto;
import com.example.portfolio.domain.user.entity.UserEntity;
import com.example.portfolio.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDto userSignIn(UserSignInDto userDto){
        if(userRepository.searchLoginIdDuplicated(userDto.getLoginId())){
            throw new DuplicateKeyException("ID is duplicated");
        }

        UserEntity user = UserEntity.builder()
                .loginid(userDto.getLoginId())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .username(userDto.getUserName())
                .activated(true)
                .build();

        UserEntity saveUser = userRepository.save(user);
        return UserDto.builder().loginId(saveUser.getLoginid()).userName(saveUser.getUsername()).build();
    }
}
