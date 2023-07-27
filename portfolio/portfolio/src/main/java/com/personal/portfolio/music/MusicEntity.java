package com.personal.portfolio.music;

import com.personal.portfolio.singer.SingerEntity;
import com.personal.portfolio.menu.MenuEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "MUSIC")
@Getter
@NoArgsConstructor
public class MusicEntity {

    @Id @GeneratedValue
    @Column(name = "MUSIC_ID")
    private Long musicID;
    @Column(name = "MUSIC_NAME")
    private String musicName;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "DELETE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteDate;
    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;

    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    private SingerEntity singerEntity;

    @Builder
    public MusicEntity(Long musicID, String musicName, Date createDate, Date deleteDate){
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
