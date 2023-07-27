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
    private Long menuId;
    @NotEmpty
    private String menuName;

    private String menuImage;
    private Date createDate;

    public MenuEntity toEntity(){
        return MenuEntity.builder()
                .menuId(menuId)
                .menuName(menuName)
                .menuImage(menuImage)
                .createDate(createDate)
                .build();
    }

    public MenuDto(MenuEntity menuEntity){
        this.menuId = menuEntity.getMenuId();
        this.menuName = menuEntity.getMenuName();
        this.menuImage = menuEntity.getMenuImage();
        this.createDate = menuEntity.getCreateDate();
    }
}
