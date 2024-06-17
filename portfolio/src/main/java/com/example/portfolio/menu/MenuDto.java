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
}
