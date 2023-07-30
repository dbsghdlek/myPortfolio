package com.personal.portfolio.hobby;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HobbyService {

    private final HobbyRepository hobbyRepository;

    @Transactional
    public List<HobbyDto> allHobby(){
        List<HobbyEntity> list =  hobbyRepository.findAll();
        List<HobbyDto> dtoList = new ArrayList<>();
        list.stream().forEach(hobbyEntity -> dtoList.add(new HobbyDto(hobbyEntity)));

        return dtoList;
    }
    @Transactional
    public HobbyDto getHobby(int hobbyId){
        return new HobbyDto((HobbyEntity) hobbyRepository.findById(hobbyId).orElseThrow());
    }
    @Transactional
    public boolean insertHobby(HobbyDto hobbyDto){
        hobbyDto.setCreateDate(LocalDateTime.now());
        return hobbyRepository.save(hobbyDto.toEntity()) != null?true:false;
    }
    @Transactional
    public boolean updateHobby(HobbyDto hobbyDto) {
        HobbyEntity hobbyEntity = hobbyRepository.findById(hobbyDto.getHobbyId()).orElseThrow();
        hobbyEntity.valueUpdate(hobbyDto);
        return hobbyRepository.save(hobbyEntity) != null?true:false;
    }
    @Transactional
    public boolean deleteHobby(int hobbyId){
        if(hobbyRepository.findById(hobbyId) != null){
            hobbyRepository.deleteById(hobbyId);
            return true;
        }else{
            return false;
        }
    }
}
