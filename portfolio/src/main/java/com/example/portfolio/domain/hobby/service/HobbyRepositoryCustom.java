package com.example.portfolio.domain.hobby.service;

import com.example.portfolio.domain.hobby.HobbyDto;

import java.util.List;

public interface HobbyRepositoryCustom {
    public List<HobbyDto> getHobbyList(int pageNumber);
}
