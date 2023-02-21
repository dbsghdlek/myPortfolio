package com.personal.portfolio.domain.repository;

import com.personal.portfolio.domain.entity.MainMenus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MenuRepository {
    private static List<MainMenus> menuList = new ArrayList<>();

    public MenuRepository(){
        menuList.add(new MainMenus(1,"ani"));
        menuList.add(new MainMenus(2,"game"));
    }

    public List<MainMenus> getMenuList(){
        return menuList;
    }
}
