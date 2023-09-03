package com.personal.portfolio.menu;

import com.personal.portfolio.domain.base.BaseDto;
import lombok.*;


import javax.validation.constraints.NotEmpty;


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

    public Menu toEntity(){
        return Menu.builder()
                .menuId(menuId)
                .menuName(menuName)
                .menuImage(menuImage)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }

    public MenuDto(Menu menu){
        this.menuId = menu.getMenuId();
        this.menuName = menu.getMenuName();
        this.menuImage = menu.getMenuImage();
        this.createDate = menu.getCreateDate();
        this.modifiedDate = menu.getModifiedDate();
    }
}
