package com.personal.portfolio.web.dto;

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
    private Date createDate;
}
