package com.example.portfolio.domain.music.repository;

import com.example.portfolio.domain.music.dto.MusicAndGenre;

import java.util.List;

public interface MusicRepositoryCustom {
    public List<MusicAndGenre> musicAllInfo(int pageNumber);

    public List<MusicAndGenre> genreByMusic(String genreName);
}
