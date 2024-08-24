package com.example.portfolio.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "USER_TABLE")
public class UserEntity {

    @Id @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "LOGIN_ID", unique = true)
    private String loginid;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "ACTIVATED")
    private boolean activated;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserAutorityEntity> authorities;

    @Builder
    public UserEntity(Long id, String loginid, String password, String username, boolean activated, Set<UserAutorityEntity> authorities) {
        this.id = id;
        this.loginid = loginid;
        this.password = password;
        this.username = username;
        this.activated = activated;
        this.authorities = authorities;
    }
}
