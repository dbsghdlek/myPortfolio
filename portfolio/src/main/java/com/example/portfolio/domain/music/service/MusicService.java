package com.example.portfolio.domain.music.service;

import com.example.portfolio.domain.music.MusicEntity;
import com.example.portfolio.domain.music.dto.MusicAndGenre;
import com.example.portfolio.domain.music.dto.MusicDto;
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

    public List<MusicAndGenre> getListByGenre(String genreName){
        return repository.genreByMusic(genreName);
    }

    public MusicDto getSingle(Long musicId){
        MusicEntity musicEntity = repository.findById(musicId).orElseThrow();
        MusicDto musicDto = new MusicDto(musicEntity);
        return musicDto;
    }

    public boolean insert(MusicDto musicDto){
        musicDto.setCreateDate(LocalDateTime.now());

        return repository.save(musicDto.toEntity()) != null?true:false;
    }

    public boolean update(MusicDto musicDto) throws IllegalArgumentException{
        MusicEntity musicEntity = repository.findById(musicDto.getMusicID()).orElseThrow();
        //수정일 변경
        musicDto.setModifiedDate(LocalDateTime.now());

        return musicEntity.valueUpdate(musicDto.toEntity());
    }

    public boolean delete(Long musicId){
        if(repository.findById(musicId) != null){
            repository.deleteById(musicId);
        }else{
            return false;
        }
        return true;
    }

}
