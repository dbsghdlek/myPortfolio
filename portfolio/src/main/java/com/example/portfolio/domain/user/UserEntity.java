package com.example.portfolio.domain.user;

import com.example.portfolio.domain.grant.GrantEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "LOGIN_ID")
    private String loginId;

    @Column(name = "PASSWORD")
    private String passWd;

    @Column(name = "USER_NAME")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "GRANT_ID")
    private GrantEntity grant;

    @Builder
    public UserEntity(Long id, String loginId, String passWd, String userName, GrantEntity grant) {
        this.id = id;
        this.loginId = loginId;
        this.passWd = passWd;
        this.userName = userName;
        this.grant = grant;
    }
}
