package com.personal.portfolio.singer;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
public class SingerDto {
    @NotEmpty
    private int SingerID;
    @NotEmpty
    private String SingerName;
    private String CreateDate;
    private Date DeleteDate;
}
