package com.personal.portfolio.music;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;


    public List<MusicDto> allMusic(){
        List<MusicEntity> entityList = musicRepository.findAll();
        List<MusicDto> list = new ArrayList<MusicDto>();;

        entityList.stream().forEach(entity -> list.add(new MusicDto(entity)));

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

    public List<MusicDto> findByGenre(String genre){
        List<MusicEntity> musicList = musicRepository.findByGenre(genre);
        List<MusicDto> dtoList =  musicList.stream().map(entity -> new MusicDto(entity)).collect(Collectors.toList());
        return  dtoList;
    }
}
