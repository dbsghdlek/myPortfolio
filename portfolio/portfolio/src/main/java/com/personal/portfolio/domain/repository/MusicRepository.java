package com.personal.portfolio.domain.repository;

import com.personal.portfolio.domain.entity.Music;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository {

    public static List<Music> musicList = new ArrayList<>();

    public MusicRepository(){
        musicList.add(new Music(1,"잠깐나올래"));
        musicList.add(new Music(2,"betelgeuse"));
    }

    public List<Music> getMusicList(){
        return musicList;
    }

}
