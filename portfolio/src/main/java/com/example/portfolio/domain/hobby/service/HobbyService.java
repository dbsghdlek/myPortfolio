package com.example.portfolio.domain.hobby.service;

import com.example.portfolio.domain.hobby.HobbyDto;
import com.example.portfolio.domain.hobby.HobbyEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class HobbyService {

    private final HobbyRepository hobbyRepository;

    public List<HobbyDto> allHobby(int pageNumber){
        return hobbyRepository.getHobbyList(pageNumber);
    }

    public HobbyDto get(int hobbyId){
        return new HobbyDto(hobbyRepository.findById(hobbyId).orElseThrow());
    }

    public boolean insert(HobbyDto hobbyDto){
        hobbyDto.setCreateDate(LocalDateTime.now());
        return hobbyRepository.save(hobbyDto.toEntity()) != null?true:false;
    }

    public boolean update(HobbyDto hobbyDto) {
        HobbyEntity hobbyEntity = hobbyRepository.findById(hobbyDto.getHobbyId()).orElseThrow();
        hobbyEntity.valueUpdate(hobbyDto);
        return hobbyRepository.save(hobbyEntity) != null?true:false;
    }

    public boolean delete(int hobbyId){
        if(hobbyRepository.findById(hobbyId) != null){
            hobbyRepository.deleteById(hobbyId);
            return true;
        }else{
            return false;
        }
    }
}
