package com.example.portfolio.domain.grant;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class GrantEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GRANT_ID")
    private int Id;

    @Column(name = "GRANT_NAME")
    private String grantName;

    @Builder
    public GrantEntity(int id, String grantName) {
        Id = id;
        this.grantName = grantName;
    }
}
