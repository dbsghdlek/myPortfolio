package com.personal.portfolio.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
public class Singer {
    @Id
    @NotEmpty
    @Column(name = "SINGER_ID")
    private int SingerID;
    @NotEmpty
    private String SingerName;
    private Date CreateDate;
    private Date DeleteDate;

}
