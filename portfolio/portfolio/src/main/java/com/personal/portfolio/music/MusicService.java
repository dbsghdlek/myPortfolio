package com.personal.portfolio.music;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    @Transactional
    public List<MusicDto> allMusic(){
        List<MusicEntity> entityList = musicRepository.findAll();
        List<MusicDto> list = new ArrayList<MusicDto>();;

        entityList.stream().forEach(entity -> list.add(new MusicDto(entity)));

        return list;
    }
    @Transactional
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
