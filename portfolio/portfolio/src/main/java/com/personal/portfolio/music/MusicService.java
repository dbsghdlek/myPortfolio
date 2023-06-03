package com.personal.portfolio.music;

import com.personal.portfolio.music.MusicEntity;
import com.personal.portfolio.music.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    public List<MusicEntity> allMusic(){
        return null;
    }
}
