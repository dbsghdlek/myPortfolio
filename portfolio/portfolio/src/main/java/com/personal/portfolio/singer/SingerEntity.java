package com.personal.portfolio.singer;

import com.personal.portfolio.music.MusicEntity;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Table(name = "SINGER")
public class SingerEntity {
    @Id
    @Column(name = "SINGER_ID")
    private int singerID;
    @Column(name = "SINGER_NAME")
    private String singerName;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "DELETE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteDate;

//    필요한 경우 주석해제하여 사용
//    @OneToMany(mappedBy = "singerEntity")
//    private List<MusicEntity> musicEntity = new ArrayList<MusicEntity>();
}
