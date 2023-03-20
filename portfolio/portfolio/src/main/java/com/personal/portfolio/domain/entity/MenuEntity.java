package com.personal.portfolio.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
@AllArgsConstructor
public class MenuEntity {
    @NotEmpty
    private int menuId;
    @NotEmpty
    private String menuName;
}
