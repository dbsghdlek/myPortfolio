package com.personal.portfolio.domain.repository;

import com.personal.portfolio.domain.entity.MusicEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository {

    public static List<MusicEntity> musicList = new ArrayList<>();

    public MusicRepository(){
        musicList.add(new MusicEntity(1,"베텔기우스",1));
        musicList.add(new MusicEntity(1,"사건의 지평선",2));
    }

    public List<MusicEntity> getMusicList(){
        return musicList;
    }

}
