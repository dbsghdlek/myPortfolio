package com.example.portfolio.menu;

import com.example.portfolio.domain.base.BaseDto;
import lombok.*;


import jakarta.validation.constraints.NotEmpty;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDto extends BaseDto {
    @NotEmpty
    private Long menuId;
    @NotEmpty
    private String menuName;
    private String menuImage;

    public MenuEntity toEntity(){
        return MenuEntity.builder()
                .menuId(menuId)
                .menuName(menuName)
                .menuImage(menuImage)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }

    public MenuDto(MenuEntity menuEntity){
        this.menuId = menuEntity.getMenuId();
        this.menuName = menuEntity.getMenuName();
        this.menuImage = menuEntity.getMenuImage();
        this.createDate = menuEntity.getCreateDate();
        this.modifiedDate = menuEntity.getModifiedDate();
    }
}
