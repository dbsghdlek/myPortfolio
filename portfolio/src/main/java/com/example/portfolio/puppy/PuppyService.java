package com.example.portfolio.puppy;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PuppyService {

    private final PuppyRepository puppyRepository;

    public List<PuppyDto> allPicture(){
        List<PuppyDto> list = new ArrayList<>();
        puppyRepository.findAll().stream().forEach(puppyEntity -> list.add(new PuppyDto(puppyEntity)));
        return list;
    }

    public boolean addPicture(PuppyDto puppyDto){
        PuppyEntity puppyEntity = puppyDto.toEntity();
        return puppyRepository.save(puppyEntity) != null?true:false;
    }
}
