package com.personal.portfolio.domain.repository;

import com.personal.portfolio.domain.entity.MenuEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MenuRepository {
    private static List<MenuEntity> menuList = new ArrayList<>();

    public MenuRepository(){
        menuList.add(new MenuEntity(1,"hobby"));
        menuList.add(new MenuEntity(3,"music"));
        menuList.add(new MenuEntity(4,"puppy"));
        menuList.add(new MenuEntity(5,"travel"));
        menuList.add(new MenuEntity(6,"food"));
    }

    public List<MenuEntity> getMenuList(){
        return menuList;
    }
}
