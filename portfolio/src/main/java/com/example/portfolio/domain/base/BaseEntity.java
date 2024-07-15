package com.example.portfolio.domain.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = "CREATE_DATE")
    protected LocalDateTime createDate;
    @Column(name = "MODIFIED_DATE")
    protected LocalDateTime modifiedDate;

}
