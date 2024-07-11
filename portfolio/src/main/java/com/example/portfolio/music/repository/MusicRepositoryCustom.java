package com.example.portfolio.music.repository;

import com.example.portfolio.music.dto.MusicAndGenre;

import java.util.List;

public interface MusicRepositoryCustom {
    public List<MusicAndGenre> musicAllInfo(int pageNumber);
}
