package com.personal.portfolio.domain.repository;


import com.personal.portfolio.domain.dto.Music;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository {

    public static List<Music> musicList = new ArrayList<>();

    public MusicRepository(){
        musicList.add(new Music().builder().musicID(1).musicName("잠깐나올래").build());
        musicList.add(new Music().builder().musicID(2).musicName("betelgeuse").build());
    }

    public List<Music> getMusicList(){
        return musicList;
    }

}
