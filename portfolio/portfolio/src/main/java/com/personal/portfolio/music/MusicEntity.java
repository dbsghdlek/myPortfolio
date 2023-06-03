package com.personal.portfolio.music;

import com.personal.portfolio.singer.SingerEntity;
import com.personal.portfolio.menu.MenuEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
public class MusicEntity {

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
    private MenuEntity menuEntity;
    @OneToMany(mappedBy = "SingerID")
    private List<SingerEntity> singerEntity = new ArrayList<SingerEntity>();
}
