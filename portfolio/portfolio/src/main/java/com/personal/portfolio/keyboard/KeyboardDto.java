package com.personal.portfolio.keyboard;

import com.personal.portfolio.domain.base.BaseDto;
import lombok.Data;

import javax.persistence.Column;
@Data
public class KeyboardDto extends BaseDto {
    private Long keyboardId;
    private String reinforcePlate;
    private Long price;
    private String company;
    private String keyCap;
    private String keyboardImage;
}
