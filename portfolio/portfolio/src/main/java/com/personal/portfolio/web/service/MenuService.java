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

    //메뉴 Entity 리스트를 Dto 리스트로 변환해주는 메서드
    public List<MenuDto> listEntityToDto(List<MenuEntity> list){

        List<MenuDto> dtoList = new ArrayList<MenuDto>();

        for(MenuEntity menuEntity : list){
            MenuDto menu = MenuDto.builder()
                    .menuId(menuEntity.getMenuId())
                    .menuName(menuEntity.getMenuName())
                    .createDate(menuEntity.getCreateDate())
                    .build();

            dtoList.add(menu);
        }

        return  dtoList;
    };

    // Entity를 Dto로 변경
    public MenuDto entityToDto(MenuEntity menuEntity){
        if(menuEntity != null){
            return MenuDto.builder()
                    .menuId(menuEntity.getMenuId())
                    .menuName(menuEntity.getMenuName())
                    .createDate(menuEntity.getCreateDate())
                    .build();
        }else{
            return null;
        }
    }

    // * 메뉴 리스트 가져오기 */
    public List<MenuDto> allMenuByJpa(){
        List<MenuEntity> Entitylist =menuRepository.findAll();

        List<MenuDto> menuList = listEntityToDto(Entitylist);

        return menuList;
    }

    //단일 메뉴 정보 가져오기
    public MenuDto getMenu(int menuId){
        Optional<MenuEntity> optionalMenu = menuRepository.findById(menuId);
        MenuEntity menuEntity = optionalMenu.orElse(null);
        MenuDto menuDto = entityToDto(menuEntity);

        return menuDto;
    }
}
