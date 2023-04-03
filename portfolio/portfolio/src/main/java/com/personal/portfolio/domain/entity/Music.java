package com.personal.portfolio.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


@Entity
public class Music {

    @Id
    @Column(name = "MUSIC_ID")
    private int musicID;
    private String musicName;
    private Date createDate;
    private Date deleteDate;
    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    private Singer singer;



}
