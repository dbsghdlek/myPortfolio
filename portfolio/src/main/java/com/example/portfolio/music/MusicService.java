package com.example.portfolio.music;

import com.example.portfolio.music.dto.MusicAndGenre;
import com.example.portfolio.music.dto.MusicDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    private final int size = 10;

    public List<MusicAndGenre> allMusic(){

        List<MusicAndGenre> list = musicRepository.musicAllInfo();

        return list;
    }

    public MusicDto getMusic(Long musicId){
        MusicEntity musicEntity = musicRepository.findById(musicId).orElseThrow();
        MusicDto musicDto = new MusicDto(musicEntity);
        return musicDto;
    }

    @Transactional
    public boolean insertMusic(MusicDto musicDto){
        musicDto.setCreateDate(LocalDateTime.now());
        MusicEntity musicEntity = musicDto.toEntity();
        return musicRepository.save(musicEntity) != null?true:false;
    }
    @Transactional
    public boolean updateMusic(MusicDto musicDto) throws IllegalArgumentException{
        MusicEntity musicEntity = musicRepository.findById(musicDto.getMusicID()).orElseThrow();
        musicEntity.valueUpdate(musicDto.toEntity());

        return musicRepository.save(musicEntity) != null?true:false;
    }

    @Transactional
    public boolean deleteMusic(Long musicId){
        if(musicRepository.findById(musicId) != null){
            musicRepository.deleteById(musicId);
        }else{
            return false;
        }
        return true;
    }

}
