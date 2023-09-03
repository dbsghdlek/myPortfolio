package com.personal.portfolio.music;

import com.personal.portfolio.domain.base.BaseEntity;
import com.personal.portfolio.genre.Genre;
import com.personal.portfolio.menu.Menu;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "MUSIC")
@Getter
@NoArgsConstructor
public class Music extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "MUSIC_ID", nullable = false)
    private Long musicID;
    @Column(name = "MUSIC_NAME", nullable = false)
    private String musicName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GENRE_NO")
    private Genre genre;
    @Column(name = "MUSIC_IMAGE")
    private String musicImage;
    @Column(name = "FILE_NAME")
    private String fileName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    private Menu menu;
    @Column(name = "SINGER_NAME", nullable = false)
    private String singerName;

    @Builder
    public Music(Long musicID, String musicName, Genre genre, String singerName, LocalDateTime createDate, LocalDateTime modifiedDate){
        this.musicID = musicID;
        this.musicName = musicName;
        this.genre = genre;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.singerName = singerName;
    }

    public void valueUpdate(Music music){
        this.musicID = music.musicID;
        this.musicName = music.musicName;
        this.genre = music.genre;
        this.createDate = music.createDate;
        this.singerName = music.singerName;
        //포맷터 적용 필요
        this.modifiedDate = LocalDateTime.now();
    }
}
