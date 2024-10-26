package com.example.portfolio.domain.puppy.service;

import com.example.portfolio.config.file.FileStore;
import com.example.portfolio.config.file.UploadFile;
import com.example.portfolio.domain.puppy.PuppyDto;
import com.example.portfolio.domain.puppy.PuppyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PuppyService {

    private final PuppyRepository repository;
    private final FileStore fileStore;

    public boolean addPicture(MultipartFile file, PuppyDto puppyDto){
        if (file.isEmpty()){
            throw new MultipartException("파일이 없습니다.");
        }
        try {
            UploadFile uploadFile = fileStore.storeFile(file);
            puppyDto.setPictureName(uploadFile.getStoreFileName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
