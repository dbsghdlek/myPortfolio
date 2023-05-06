package com.personal.portfolio.web.service;


import com.personal.portfolio.domain.repository.MenuRepository;
import com.personal.portfolio.web.dto.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

}
