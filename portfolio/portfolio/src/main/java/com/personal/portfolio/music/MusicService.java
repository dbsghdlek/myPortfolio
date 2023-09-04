package com.personal.portfolio.music;



import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    private final int size = 10;

    public List<MusicDto> allMusic(){
        List<Music> entityList = musicRepository.findAll();
        List<MusicDto> list = new ArrayList<MusicDto>();;

        entityList.stream().forEach(entity -> list.add(new MusicDto(entity)));

        return list;
    }

    public MusicDto getMusic(Long musicId){
        Music music = musicRepository.findById(musicId).orElseThrow();
        MusicDto musicDto = new MusicDto(music);
        return musicDto;
    }

    @Transactional
    public boolean insertMusic(MusicDto musicDto){
        musicDto.setCreateDate(LocalDateTime.now());
        Music music = musicDto.toEntity();
        return musicRepository.save(music) != null?true:false;
    }
    @Transactional
    public boolean updateMusic(MusicDto musicDto) throws IllegalArgumentException{
        Music music = musicRepository.findById(musicDto.getMusicID()).orElseThrow();
        music.valueUpdate(musicDto.toEntity());

        return musicRepository.save(music) != null?true:false;
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

    public List<MusicDto> findByGenre(String genreName){
        PageRequest pageRequest = PageRequest.of(0,size);
        Genre genre = Genre.valueOf(genreName.toUpperCase(Locale.ROOT));
        List<MusicDto> musicList = musicRepository.findByGenre(genre, pageRequest).stream()
                                    .map(entity -> new MusicDto(entity))
                                    .collect(Collectors.toList());
        return  musicList;
    }

    public List<MusicDto> findBySinger(String singerName){
        PageRequest pageRequest = PageRequest.of(0, size);
        List<Music> list =musicRepository.findBySinger(singerName, pageRequest);
        List<MusicDto> musicList = musicRepository.findBySinger(singerName, pageRequest).stream()
                                                .map(music -> new MusicDto(music))
                                                .collect(Collectors.toList());

        return musicList;
    }
}
