package com.personal.portfolio.domain.repository;

import com.personal.portfolio.domain.entity.Music;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository {

    public static List<Music> musicList = new ArrayList<>();

    public MusicRepository(){
        musicList.add(new Music(1,"베텔기우스"));
        musicList.add(new Music(1,"사건의 지평선"));
    }

    public List<Music> getMusicList(){
        return musicList;
    }

}
