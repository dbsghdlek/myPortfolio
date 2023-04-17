package com.personal.portfolio.web.dto;

import com.personal.portfolio.domain.entity.Singer;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
