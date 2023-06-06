package com.personal.portfolio.menu;

import lombok.*;


import javax.validation.constraints.NotEmpty;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDto {
    @NotEmpty
    private int menuId;
    @NotEmpty
    private String menuName;
    private String createDate;

    public MenuEntity toEntity(){
        return MenuEntity.builder()
                .menuId(menuId)
                .menuName(menuName)
                .createDate(createDate)
                .build();
    }

    public MenuDto(MenuEntity menuEntity){
        this.menuId = menuEntity.getMenuId();
        this.menuName = menuEntity.getMenuName();
        this.createDate = menuEntity.getCreateDate();
    }
}
