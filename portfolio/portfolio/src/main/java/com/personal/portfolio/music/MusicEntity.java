package com.personal.portfolio.music;

import com.personal.portfolio.domain.base.BaseEntity;
import com.personal.portfolio.menu.MenuEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


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
    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE")
    private Genre genre;
    @Column(name = "MUSIC_IMAGE")
    private String musicImage;
    @Column(name = "FILE_NAME")
    private String fileName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;
    @Column(name = "SINGER_NAME", nullable = false)
    private String singerName;

    @Builder
    public MusicEntity(Long musicID, String musicName, Genre genre, String singerName, LocalDateTime createDate, LocalDateTime modifiedDate){
        this.musicID = musicID;
        this.musicName = musicName;
        this.genre = genre;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.singerName = singerName;
    }

    public void valueUpdate(MusicEntity musicEntity){
        this.musicID = musicEntity.musicID;
        this.musicName = musicEntity.musicName;
        this.genre = musicEntity.genre;
        this.createDate = musicEntity.createDate;
        this.singerName = musicEntity.singerName;
        //포맷터 적용 필요
        this.modifiedDate = LocalDateTime.now();
    }
}
