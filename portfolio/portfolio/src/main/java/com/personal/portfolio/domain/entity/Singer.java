package com.personal.portfolio.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Singer {
    @Id
    @Column(name = "SINGER_ID")
    private int SingerID;
    private String SingerName;
    private Date CreateDate;
    private Date DeleteDate;
}
