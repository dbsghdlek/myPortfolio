package com.personal.portfolio.menu;


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
        List<MenuEntity> entityList =menuRepository.findAll();

        List<MenuDto> menuList = new ArrayList<>();
        entityList.stream().forEach(entity -> menuList.add(new MenuDto(entity)));

        return menuList;
    }

    //단일 메뉴 정보 가져오기
    public MenuDto getMenu(Long menuId){
        MenuEntity MenuEntity = menuRepository.findById(menuId).orElseThrow();
        MenuDto menuDto = new MenuDto(MenuEntity);
        return menuDto;
    }

    public MenuDto getMenuUsingQueryDsl(Long menuId){
        MenuEntity menuEntity = menuRepository.getMenuUsingQueryDsl(menuId);
        MenuDto menuDto = new MenuDto(menuEntity);
        return menuDto;
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

    public boolean deleteMenu(Long menuId){
        if(menuRepository.findById(menuId) != null){
            menuRepository.deleteById(menuId);
        }else{
            return false;
        }
        return true;
    }
}
