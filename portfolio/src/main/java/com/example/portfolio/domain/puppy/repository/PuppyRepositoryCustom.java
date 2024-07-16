package com.example.portfolio.domain.puppy.repository;

import com.example.portfolio.domain.puppy.PuppyDto;

import java.util.List;

public interface PuppyRepositoryCustom {
    public List<PuppyDto> searchingByPuppyName(String puppyName, int pageNumber);
}
