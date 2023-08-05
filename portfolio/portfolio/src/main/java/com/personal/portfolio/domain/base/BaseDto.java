package com.personal.portfolio.domain.base;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
@Data
public abstract class BaseDto {

    public LocalDateTime createDate;
    public LocalDateTime modifiedDate;
}
