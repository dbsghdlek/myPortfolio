package com.personal.portfolio.singer;

import com.personal.portfolio.music.MusicEntity;
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
    private String CreateDate;
    @Column(name = "DELETE_DATE")
    private String DeleteDate;
    @ManyToOne
    @JoinColumn(name = "MUSIC_ID")
    private MusicEntity musicEntity;
}
