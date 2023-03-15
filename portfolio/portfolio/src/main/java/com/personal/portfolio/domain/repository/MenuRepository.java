package com.personal.portfolio.domain.repository;

import com.personal.portfolio.domain.entity.MainMenus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MenuRepository {
    private static List<MainMenus> menuList = new ArrayList<>();

    public MenuRepository(){
        menuList.add(new MainMenus(1,"hobby"));
        menuList.add(new MainMenus(2,"game"));
        menuList.add(new MainMenus(3,"music"));
        menuList.add(new MainMenus(4,"puppy"));
        menuList.add(new MainMenus(5,"travel"));
        menuList.add(new MainMenus(6,"food"));
    }

    public List<MainMenus> getMenuList(){
        return menuList;
    }
}
