package com.personal.portfolio.domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Singer {
    @Id
    @Column(name = "SINGER_ID")
    private int SingerID;
    @Column(name = "SINGER_NAME")
    private String SingerName;
    @Column(name = "CREATE_DATE")
    private Date CreateDate;
    @Column(name = "DELETE_DATE")
    private Date DeleteDate;
    @ManyToOne
    @JoinColumn(name = "MUSIC_ID")
    private Music music;
}
