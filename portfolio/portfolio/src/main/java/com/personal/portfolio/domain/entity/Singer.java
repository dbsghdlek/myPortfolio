package com.personal.portfolio.domain.entity;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class SingerEntity {
    @NotEmpty
    private int SingerID;
    @NotEmpty
    private String SingerName;
    private Date CreateDate;
    private Date DeleteDate;

}
