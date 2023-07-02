package com.personal.portfolio.music;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    public List<MusicDto> listEntityToDto(List<MusicEntity> list){

        List<MusicDto> dtoList = new ArrayList<MusicDto>();
        list.stream().forEach(entity -> dtoList.add(new MusicDto(entity)));

        return  dtoList;
    };

    public List<MusicDto> allMusic(){
        List<MusicEntity> entityList = musicRepository.findAll();
        List<MusicDto> list = listEntityToDto(entityList);
        return list;
    }

    public MusicDto getMusic(int musicId){
        MusicEntity musicEntity = musicRepository.findById(musicId).orElseThrow();
        MusicDto musicDto = new MusicDto(musicEntity);
        return musicDto;
    }

    public boolean insertMusic(MusicDto musicDto){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        musicDto.setCreateDate(formatter.format(new Date()));
        MusicEntity musicEntity = musicDto.toEntity();
        return musicRepository.save(musicEntity) != null?true:false;
    }

    public boolean updateMusic(MusicDto musicDto){
        MusicEntity musicEntity = musicRepository.findById(musicDto.getMusicID()).orElseThrow();
        musicEntity.valueUpdate(musicDto.toEntity());

        return musicRepository.save(musicEntity) != null?true:false;
    }

    public boolean deleteMusic(int musicId){
        if(musicRepository.findById(musicId) != null){
            musicRepository.deleteById(musicId);
        }else{
            return false;
        }
        return true;
    }
}
