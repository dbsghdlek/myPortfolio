package com.personal.portfolio.domain.repository;

import com.personal.portfolio.domain.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MenuRepository {
    private static List<Menu> menuList = new ArrayList<>();

    public MenuRepository(){
        menuList.add(new Menu(1,"hobby"));
        menuList.add(new Menu(3,"music"));
        menuList.add(new Menu(4,"puppy"));
        menuList.add(new Menu(5,"travel"));
        menuList.add(new Menu(6,"food"));
    }

    public List<Menu> getMenuList(){
        return menuList;
    }
}
