package com.example.portfolio.domain.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@Entity
@Table(name = "AUTHORITY")
@NoArgsConstructor
public class AuthorityEntity {
    @Id
    @Column(name = "AUTHORITY_NAME")
    private String authorityName;

    @OneToMany(mappedBy = "authority", fetch = FetchType.EAGER)
    private List<UserAutorityEntity> users;

    @Builder
    public AuthorityEntity(String authorityName) {
        this.authorityName = authorityName;
//        this.users = users;
    }
}
