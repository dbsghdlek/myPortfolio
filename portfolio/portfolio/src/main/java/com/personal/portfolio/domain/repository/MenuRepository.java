package com.personal.portfolio.domain.repository;


import com.personal.portfolio.domain.dto.Menu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MenuRepository {
    private static List<Menu> menuList = new ArrayList<>();

    public MenuRepository(){
        menuList.add(new Menu().builder().menuId(1).menuName("hobby").build());
        menuList.add(new Menu().builder().menuId(2).menuName("music").build());
        menuList.add(new Menu().builder().menuId(3).menuName("puppy").build());
        menuList.add(new Menu().builder().menuId(4).menuName("travel").build());
        menuList.add(new Menu().builder().menuId(5).menuName("food").build());
    }

    public List<Menu> getMenuList(){
        return menuList;
    }
}
