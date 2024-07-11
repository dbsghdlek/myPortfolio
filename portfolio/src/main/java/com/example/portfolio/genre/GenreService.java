package com.example.portfolio.genre;

import com.example.portfolio.genre.repository.GenreRepository;
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
