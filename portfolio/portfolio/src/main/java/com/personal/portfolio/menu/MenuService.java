package com.personal.portfolio.menu;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            MenuDto menu = new MenuDto(menuEntity);
            dtoList.add(menu);
        }

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
        Optional<MenuEntity> optionalMenu = menuRepository.findById(menuId);
        MenuEntity menuEntity = optionalMenu.orElse(null);
        MenuDto menuDto = new MenuDto(menuEntity);
        return menuDto;
    }

    public MenuEntity insertMenu(MenuDto menuDto){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        menuDto.setCreateDate(formatter.format(new Date()));
        MenuEntity menuEntity = menuDto.toEntity();
        MenuEntity result = menuRepository.save(menuEntity);
        return result;
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
