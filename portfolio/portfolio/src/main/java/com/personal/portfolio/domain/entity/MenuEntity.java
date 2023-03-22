package com.personal.portfolio.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
@Data
@AllArgsConstructor
public class MenuEntity {
    @Id
    @NotEmpty
    private int menuId;
    @NotEmpty
    private String menuName;
}
