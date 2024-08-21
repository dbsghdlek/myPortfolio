package com.example.portfolio.domain.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;

import java.time.LocalDate;

@Entity
@Table(name = "USER_AUTHORITY")
@Getter
@NoArgsConstructor
public class UserAutorityEntity implements Persistable<UserAuthKey> {

    @EmbeddedId
    private UserAuthKey userAuthKey;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @MapsId("authorityName")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTHORITY_NAME")
    private AuthorityEntity authority;

    @CreatedDate
    private LocalDate created;

    @Builder
    public UserAutorityEntity(UserAuthKey userAuthKey, UserEntity user, AuthorityEntity authority) {
        this.userAuthKey = userAuthKey;
        this.user = user;
        this.authority = authority;
    }

    @Override
    public UserAuthKey getId() {
        return userAuthKey;
    }

    @Override
    public boolean isNew() {
        return created == null;
    }
}
