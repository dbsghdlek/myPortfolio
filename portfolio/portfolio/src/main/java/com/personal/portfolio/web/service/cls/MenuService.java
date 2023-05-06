package com.personal.portfolio.web.service.cls;


import com.personal.portfolio.domain.dao.MenuMapper;
import com.personal.portfolio.web.dto.Menu;
import com.personal.portfolio.web.service.inter.MenuServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService implements MenuServiceInter {
    private final MenuMapper menuMapper;
    @Override
    public List<Menu> allMenu() {
        return menuMapper.getAllUser();
    }
}
