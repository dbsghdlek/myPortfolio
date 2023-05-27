package com.personal.portfolio.web.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Music {
    @NotEmpty
    private int musicID;
    @NotEmpty
    private String musicName;
    private Date createDate;
    private Date deleteDate;

}
