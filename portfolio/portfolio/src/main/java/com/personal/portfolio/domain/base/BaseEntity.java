package com.personal.portfolio.domain.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = "CREATE_DATE")
    public LocalDateTime createDate;
    @Column(name = "MODIFIED_DATE")
    public LocalDateTime modifiedDate;

}
