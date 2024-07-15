package com.example.portfolio.domain.puppy;

import com.example.portfolio.domain.puppy.repository.PuppyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PuppyService {

    private final PuppyRepository repository;

    public boolean addPicture(PuppyDto puppyDto){
        return repository.save(puppyDto.toEntity()) != null?true:false;
    }

    public List<PuppyDto> searchPuppyName(String puppyName){
        return repository.searching(puppyName);
    }
}
