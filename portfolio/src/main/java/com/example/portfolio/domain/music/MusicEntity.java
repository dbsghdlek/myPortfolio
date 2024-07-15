package com.example.portfolio.domain.music;

import com.example.portfolio.domain.base.BaseEntity;
import com.example.portfolio.domain.genre.GenreEntity;
import com.example.portfolio.domain.menu.MenuEntity;
import lombok.*;

import jakarta.persistence.*;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="GENRE_ID")
    private GenreEntity genreEntity;
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
    public MusicEntity(Long musicID, String musicName,  String singerName, GenreEntity genre, LocalDateTime createDate, LocalDateTime modifiedDate){
        this.musicID = musicID;
        this.musicName = musicName;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.singerName = singerName;
        this.genreEntity = genre;
    }

    public boolean valueUpdate(MusicEntity musicEntity){
        try {
            this.musicName = musicEntity.musicName;
            this.singerName = musicEntity.singerName;
            //포맷터 적용 필요
            this.modifiedDate = LocalDateTime.now();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
