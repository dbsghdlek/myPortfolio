package com.personal.portfolio.web.service;

import com.personal.portfolio.domain.entity.MusicEntity;
import com.personal.portfolio.domain.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    public List<MusicEntity> allMusic(){
        return null;
    }
}
