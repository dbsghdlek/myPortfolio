package com.personal.portfolio.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Music {

    @Id
    @Column(name = "MUSIC_ID")
    private int musicID;
    @Column(name = "MUSIC_NAME")
    private String musicName;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "DELETE_DATE")
    private Date deleteDate;
    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private Menu menu;
    @OneToMany(mappedBy = "SingerID")
    private List<Singer> singer = new ArrayList<Singer>();
}
