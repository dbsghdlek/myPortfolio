package com.personal.portfolio.menu;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

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
        list.stream().forEach(menuEntity -> dtoList.add(new MenuDto(menuEntity)));

        return  dtoList;
    };

    // * 메뉴 리스트 가져오기 */
    public List<MenuDto> allMenuByJpa(){
        List<MenuEntity> Entitylist =menuRepository.findAll();

        List<MenuDto> menuList = listEntityToDto(Entitylist);

        return menuList;
    }

    //단일 메뉴 정보 가져오기
    public MenuDto getMenu(int menuId){
        MenuEntity MenuEntity = menuRepository.findById(menuId).orElseThrow();
        MenuDto menuDto = new MenuDto(MenuEntity);
        return menuDto;
    }

    public boolean insertMenu(MenuDto menuDto){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        menuDto.setCreateDate(formatter.format(new Date()));
        MenuEntity menuEntity = menuDto.toEntity();
        return menuRepository.save(menuEntity) != null?true:false;
    }

    public boolean updateMenu(MenuDto menuDto){
        MenuEntity menuEntity = menuRepository.findById(menuDto.getMenuId()).orElseThrow();
        menuEntity.valueUpdate(menuDto.toEntity());

        return menuRepository.save(menuEntity) != null?true:false;
    }

    public boolean deleteMenu(int menuId){
        if(menuRepository.findById(menuId) != null){
            menuRepository.deleteById(menuId);
        }else{
            return false;
        }
        return true;
    }
}
