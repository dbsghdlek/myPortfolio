package com.example.portfolio.domain.user.dto;

import com.example.portfolio.domain.user.entity.AuthorityEntity;
import com.example.portfolio.domain.user.entity.UserEntity;
import com.querydsl.core.annotations.QueryProjection;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String loginId;

    @NotNull
    @Size(min = 3, max = 50)
    private String password;

    @NotNull
    @Size(min = 3, max = 30)
    private String userName;

    private boolean activated;

    private Set<AutorityDto> authorities;

    @QueryProjection
    public UserDto(UserEntity user, List<AuthorityEntity> authorities){
        this.id = user.getId();
        this.loginId = user.getLoginid();
        this.userName = user.getUsername();
        this.password = user.getPassword();
        this.activated = user.isActivated();
        authorities.stream().forEach(authority -> this.authorities.add(AutorityDto.builder()
                .authorityName(authority.getAuthorityName()).build()));
    }
}
