package com.personal.portfolio.domain.dao;

import com.personal.portfolio.web.dto.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    public List<Menu> getAllUser();
}
