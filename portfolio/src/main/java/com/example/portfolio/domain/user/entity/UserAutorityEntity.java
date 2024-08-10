package com.example.portfolio.domain.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "USER_AUTHORITY")
@Getter
public class UserAutorityEntity {

    @EmbeddedId
    private UserAuthKey userAuthKey;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @MapsId("authorityName")
    @ManyToOne
    @JoinColumn(name = "AUTHORITY_NAME")
    private AuthorityEntity authority;

    @Builder
    public UserAutorityEntity(UserEntity user, AuthorityEntity authority) {
        this.user = user;
        this.authority = authority;
    }
}
