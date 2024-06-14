package com.example.portfolio.domain.base;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
@Data
@Getter
public abstract class BaseDto {

    public LocalDateTime createDate;
    public LocalDateTime modifiedDate;
}
