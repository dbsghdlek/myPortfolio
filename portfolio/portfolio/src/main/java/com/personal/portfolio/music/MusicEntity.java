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
@NoArgsConstructor
public class MusicEntity {

    @Id
    @Column(name = "MUSIC_ID")
    private int musicID;
    @Column(name = "MUSIC_NAME")
    private String musicName;
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Column(name = "DELETE_DATE")
    private String deleteDate;
    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;
    @OneToMany(mappedBy = "SingerID")
    private List<SingerEntity> singerEntity = new ArrayList<SingerEntity>();

    @Builder
    public MusicEntity(int musicID, String musicName, String createDate, String deleteDate){
        this.musicID = musicID;
        this.musicName = musicName;
        this.createDate = createDate;
        this.deleteDate = deleteDate;
    }

    public void valueUpdate(MusicEntity musicEntity){
        this.musicID = musicEntity.musicID;
        this.musicName = musicEntity.musicName;
        this.createDate = musicEntity.createDate;
        this.deleteDate = musicEntity.deleteDate;
    }
}
