package com.personal.portfolio.music;

import com.personal.portfolio.domain.base.BaseEntity;
import com.personal.portfolio.singer.SingerEntity;
import com.personal.portfolio.menu.MenuEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "MUSIC")
@Getter
@NoArgsConstructor
public class MusicEntity extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "MUSIC_ID", nullable = false)
    private Long musicID;
    @Column(name = "MUSIC_NAME", nullable = false)
    private String musicName;
    @Column(name = "MUSIC_IMAGE")
    private String musicImage;
    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;
    @ManyToOne
    @JoinColumn(name = "SINGER_ID", nullable = false)
    private SingerEntity singerEntity;

    @Builder
    public MusicEntity(Long musicID, String musicName, LocalDateTime createDate, LocalDateTime modifiedDate){
        this.musicID = musicID;
        this.musicName = musicName;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public void valueUpdate(MusicEntity musicEntity){
        this.musicID = musicEntity.musicID;
        this.musicName = musicEntity.musicName;
        this.createDate = musicEntity.createDate;
        //포맷터 적용 필요
        this.modifiedDate = LocalDateTime.now();
    }
}
