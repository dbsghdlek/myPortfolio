package com.personal.portfolio.web.service;


import com.personal.portfolio.domain.dao.MenuMapper;
import com.personal.portfolio.domain.entity.MenuEntity;
import com.personal.portfolio.domain.repository.MenuRepository;
import com.personal.portfolio.web.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuService {
    private final MenuMapper menuMapper;

    private final MenuRepository menuRepository;

    public List<MenuDto> allMenu() {
        return menuMapper.getAllUser();
    }

    // * 메뉴 리스트 가져오기 */
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

    //단일 메뉴 정보 가져오기
    public MenuDto getMenu(int menuId){
        Optional<MenuEntity> optionalMenu = menuRepository.findById(menuId);
        MenuEntity menuEntity = optionalMenu.orElse(null);
        MenuDto menuDto = new MenuDto();
        if(menuEntity != null){
            menuDto.builder()
                    .menuId(menuEntity.getMenuId())
                    .menuName(menuEntity.getMenuName())
                    .createDate(menuEntity.getCreateDate());
            log.info("menuDto Output [{}, {}, {}]", menuDto.getMenuId(), menuDto.getMenuName(), menuDto.getCreateDate());
        }else{
            menuDto = null;
        }
        return menuDto;
    }
}
