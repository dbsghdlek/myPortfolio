package com.example.portfolio.puppy;

import com.example.portfolio.puppy.repository.PuppyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PuppyService {

    private final PuppyRepository puppyRepository;

    public boolean addPicture(PuppyDto puppyDto){
        PuppyEntity puppyEntity = puppyDto.toEntity();
        return puppyRepository.save(puppyEntity) != null?true:false;
    }
}
