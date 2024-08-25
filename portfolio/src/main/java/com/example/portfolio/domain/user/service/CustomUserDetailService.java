package com.example.portfolio.domain.user.service;

import com.example.portfolio.domain.user.entity.UserEntity;
import com.example.portfolio.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String loginid) throws UsernameNotFoundException {
        return userRepository.findOneWithAuthoritiesByloginid(loginid)
                .map(user -> createUser(loginid, user))
                .orElseThrow(()-> new UsernameNotFoundException(loginid + " -> 데이터베이스에서 찾을 수 없습니다."));
    }
    private org.springframework.security.core.userdetails.User createUser(String loginid, UserEntity user){
        if(!user.isActivated()){
            throw new RuntimeException(loginid + "-> 활성화되어 있지 않습니다.");
        }

        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority().getAuthorityName()))
                .collect(Collectors.toList());

        return new User(user.getLoginid()
                ,user.getPassword()
                , grantedAuthorities);
    }
}
