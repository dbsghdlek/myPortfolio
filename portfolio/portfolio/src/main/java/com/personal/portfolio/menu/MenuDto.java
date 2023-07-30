package com.personal.portfolio.menu;

import com.personal.portfolio.domain.base.BaseEntity;
import lombok.*;


import javax.validation.constraints.NotEmpty;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDto extends BaseEntity {
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
