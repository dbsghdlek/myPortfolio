package com.example.portfolio.genre;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    public List<GenreDto> genreList(){
        List<GenreDto> genreList = genreRepository.genreList();
        return genreList;
    }
}
