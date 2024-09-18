package com.example.portfolio.domain.keyboard.service;

import com.example.portfolio.domain.keyboard.KeyboardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeyboardService {
    private final KeyboardRepository keyboardRepository;

    public List<KeyboardDto> getKeyboardList(int pageNumber){
        List<KeyboardDto> list = keyboardRepository.keyboardDtoList(pageNumber);

        return list;
    }
}
