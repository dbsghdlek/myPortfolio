package com.personal.portfolio.web.service;


import com.personal.portfolio.domain.dao.MenuMapper;
import com.personal.portfolio.domain.entity.MenuEntity;
import com.personal.portfolio.domain.repository.MenuRepository;
import com.personal.portfolio.web.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuMapper menuMapper;

    private final MenuRepository menuRepository;

    public List<MenuDto> allMenu() {
        return menuMapper.getAllUser();
    }

    public List<MenuDto> allMenuByJpa(){
        List<MenuEntity> Entitylist =menuRepository.findAll();
        List<MenuDto> dtoList = new ArrayList<MenuDto>();
        for(MenuEntity menuEntity : Entitylist){
            MenuDto menu = new MenuDto();
            menu.builder()
                    .menuId(menuEntity.getMenuId())
                    .menuName(menuEntity.getMenuName())
                    .createDate(menuEntity.getCreateDate());
            dtoList.add(menu);
        }
        return  dtoList;
    }
}
