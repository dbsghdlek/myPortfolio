package com.example.portfolio.domain.puppy.service;

import com.example.portfolio.domain.puppy.PuppyDto;
import com.example.portfolio.domain.puppy.PuppyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PuppyService {

    private final PuppyRepository repository;

    public boolean addPicture(PuppyDto puppyDto){
        return repository.save(puppyDto.toEntity()) != null?true:false;
    }

    public List<PuppyDto> searchPuppyName(String puppyName, int pageNumber){
        return repository.searchingByPuppyName(puppyName, pageNumber);
    }

    public boolean updatePuppy(PuppyDto dto){
        dto.setModifiedDate(LocalDateTime.now());
        PuppyEntity entity = repository.findById(dto.getPictureId()).orElseThrow();
        return entity.valueUpdate(dto);
    }

    public void deletePuppy(Long id){
        repository.deleteById(id);
    }
}
