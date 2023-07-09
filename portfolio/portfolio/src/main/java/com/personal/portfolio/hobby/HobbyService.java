package com.personal.portfolio.hobby;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HobbyService {

    private final HobbyRepository hobbyRepository;

    private List<HobbyDto> toDtoList(List<HobbyEntity> list){
        List<HobbyDto> dtoList = new ArrayList<>();
        list.stream().forEach(hobbyEntity -> dtoList.add(new HobbyDto(hobbyEntity)));
        return dtoList;
    }

    public List<HobbyDto> allHobby(){
        List<HobbyDto> list =  toDtoList(hobbyRepository.findAll());
        return list;
    }

    public HobbyDto getHobby(int hobbyId){
        return new HobbyDto((HobbyEntity) hobbyRepository.findById(hobbyId).orElseThrow());
    }

    public boolean insertHobby(HobbyDto hobbyDto){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        hobbyDto.setCreateDate(formatter.format(new Date()));
        return hobbyRepository.save(hobbyDto.toEntity()) != null?true:false;
    }

    public boolean updateHobby(HobbyDto hobbyDto){
        HobbyEntity hobbyEntity = hobbyRepository.findById(hobbyDto.getHobbyId()).orElseThrow();
        hobbyEntity.valueUpdate(hobbyDto);
        return hobbyRepository.save(hobbyEntity) != null?true:false;
    }

    public boolean deleteHobby(int hobbyId){
        if(hobbyRepository.findById(hobbyId) != null){
            hobbyRepository.deleteById(hobbyId);
            return true;
        }else{
            return false;
        }
    }
}
