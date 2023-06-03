package com.personal.portfolio.menu;

import com.personal.portfolio.menu.MenuDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MenuMapper {
    public List<MenuDto> getAllUser();

    public int addMenu(MenuDto menu);
}
