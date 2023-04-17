package com.personal.portfolio.web.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
public class Singer {
    @NotEmpty
    private int SingerID;
    @NotEmpty
    private String SingerName;
    private Date CreateDate;
    private Date DeleteDate;

}
