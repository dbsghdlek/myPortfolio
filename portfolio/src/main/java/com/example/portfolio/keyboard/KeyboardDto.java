package com.example.portfolio.keyboard;

import com.example.portfolio.domain.base.BaseDto;
import lombok.Data;

@Data
public class KeyboardDto extends BaseDto {
    private Long keyboardId;
    private String reinforcePlate;
    private Long price;
    private String company;
    private String keyCap;
    private String keyboardImage;
}
