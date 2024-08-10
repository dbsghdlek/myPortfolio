package com.example.portfolio.domain.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "USER")
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "LOGIN_ID", unique = true)
    private String loginId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "ACTIVATED")
    private boolean activated;

    @OneToMany(mappedBy = "user")
    private Set<UserAutorityEntity> authorities;

    @Builder
    public UserEntity(Long id, String loginId, String password, String userName, boolean activated, Set<UserAutorityEntity> authorities) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.activated = activated;
        this.authorities = authorities;
    }
}
