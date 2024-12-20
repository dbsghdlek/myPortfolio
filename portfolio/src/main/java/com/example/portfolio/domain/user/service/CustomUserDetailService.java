package com.example.portfolio.domain.user.service;

import com.example.portfolio.config.jwt.CustomUserDetails;
import com.example.portfolio.domain.user.entity.UserEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

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
                .orElseThrow(() -> new UsernameNotFoundException(loginid + " -> 데이터베이스에서 찾을 수 없습니다."));
    }
    private CustomUserDetails createUser(String loginid, UserEntity user){
        if(!user.isActivated()){
            throw new RuntimeException(loginid + "-> 활성화되어 있지 않습니다.");
        }

        List<String> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new String(authority.getAuthority().getAuthorityName()))
                .collect(Collectors.toList());

        return new CustomUserDetails(user.getLoginid()
                ,user.getPassword()
                , grantedAuthorities);
    }
}
