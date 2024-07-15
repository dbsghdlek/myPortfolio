package com.example.portfolio.domain.menu;

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
                .menuId(this.menuId)
                .menuName(this.menuName)
                .createDate(this.createDate)
                .modifiedDate(this.modifiedDate)
                .menuImage(this.menuImage)
                .build();
    }
}
