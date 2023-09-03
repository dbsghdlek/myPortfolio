package com.personal.portfolio.puppy;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PuppyService {

    private final PuppyRepository puppyRepository;

    public List<PuppyDto> allPicture(){
        List<PuppyDto> list = new ArrayList<>();
        puppyRepository.findAll().stream().forEach(puppy -> list.add(new PuppyDto(puppy)));
        return list;
    }

    public boolean addPicture(PuppyDto puppyDto){
        Puppy puppy = puppyDto.toEntity();
        return puppyRepository.save(puppy) != null?true:false;
    }
}
