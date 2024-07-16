package com.example.portfolio.domain.menu;


import com.example.portfolio.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    // * 메뉴 리스트 가져오기 */
    public List<MenuDto> allMenuByJpa(){
        List<MenuDto> menuList = menuRepository.findByMenuDto();

        return menuList;
    }

    public boolean insertMenu(MenuDto menuDto){
        menuDto.setCreateDate(LocalDateTime.now());
        MenuEntity menuEntity = menuDto.toEntity();
        return menuRepository.save(menuEntity) != null?true:false;
    }

    public boolean updateMenu(MenuDto menuDto){
        MenuEntity menuEntity = menuRepository.findById(menuDto.getMenuId()).orElseThrow();
        menuEntity.valueUpdate(menuDto.toEntity());

        return menuRepository.save(menuEntity) != null?true:false;
    }

    public void deleteMenu(Long menuId){
        menuRepository.deleteById(menuId);
    }
}
