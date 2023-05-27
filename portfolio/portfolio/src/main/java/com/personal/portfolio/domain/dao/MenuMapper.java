package com.personal.portfolio.domain.dao;

import com.personal.portfolio.web.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Repository
public interface MenuMapper {
    public List<MenuDto> getAllUser();

    public int addMenu(MenuDto menu);
}
