package com.personal.portfolio.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class SingerEntity {
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
    private MusicEntity musicEntity;
}
