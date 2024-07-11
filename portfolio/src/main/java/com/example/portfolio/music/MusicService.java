package com.example.portfolio.music;

import com.example.portfolio.music.dto.MusicAndGenre;
import com.example.portfolio.music.dto.MusicDto;
import com.example.portfolio.music.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MusicService {
    private final MusicRepository repository;

    public List<MusicAndGenre> allMusic(int pageNumber){

        List<MusicAndGenre> list = repository.musicAllInfo(pageNumber);

        return list;
    }

    public MusicDto getMusic(Long musicId){
        MusicEntity musicEntity = repository.findById(musicId).orElseThrow();
        MusicDto musicDto = new MusicDto(musicEntity);
        return musicDto;
    }

    public boolean insertMusic(MusicDto musicDto){
        musicDto.setCreateDate(LocalDateTime.now());

        return repository.save(musicDto.toEntity()) != null?true:false;
    }

    public boolean updateMusic(MusicDto musicDto) throws IllegalArgumentException{
        MusicEntity musicEntity = repository.findById(musicDto.getMusicID()).orElseThrow();
        musicEntity.valueUpdate(musicDto.toEntity());

        return repository.save(musicEntity) != null?true:false;
    }

    public boolean deleteMusic(Long musicId){
        if(repository.findById(musicId) != null){
            repository.deleteById(musicId);
        }else{
            return false;
        }
        return true;
    }

}
