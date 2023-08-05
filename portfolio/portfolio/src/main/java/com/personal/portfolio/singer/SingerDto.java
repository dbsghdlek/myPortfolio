package com.personal.portfolio.singer;

import com.personal.portfolio.domain.base.BaseDto;
import com.personal.portfolio.domain.base.BaseEntity;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
public class SingerDto extends BaseDto {
    @NotEmpty
    private int SingerID;
    @NotEmpty
    private String SingerName;
}
