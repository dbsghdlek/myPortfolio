package com.example.portfolio.music;

import com.example.portfolio.music.dto.MusicAndGenre;
import com.example.portfolio.music.dto.MusicDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MusicService {
    private final MusicRepository musicRepository;

    public List<MusicAndGenre> allMusic(int pageNumber){

        List<MusicAndGenre> list = musicRepository.musicAllInfo(pageNumber);

        return list;
    }

    public MusicDto getMusic(Long musicId){
        MusicEntity musicEntity = musicRepository.findById(musicId).orElseThrow();
        MusicDto musicDto = new MusicDto(musicEntity);
        return musicDto;
    }

    public boolean insertMusic(MusicDto musicDto){
        musicDto.setCreateDate(LocalDateTime.now());

        return musicRepository.save(musicDto.toEntity()) != null?true:false;
    }

    public boolean updateMusic(MusicDto musicDto) throws IllegalArgumentException{
        MusicEntity musicEntity = musicRepository.findById(musicDto.getMusicID()).orElseThrow();
        musicEntity.valueUpdate(musicDto.toEntity());

        return musicRepository.save(musicEntity) != null?true:false;
    }

    public boolean deleteMusic(Long musicId){
        if(musicRepository.findById(musicId) != null){
            musicRepository.deleteById(musicId);
        }else{
            return false;
        }
        return true;
    }

}
