package com.example.portfolio.domain.keyboard;

import com.example.portfolio.domain.base.BaseDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class KeyboardDto extends BaseDto {

    @NotEmpty
    private Long keyboardId;
    private String reinforcePlate;
    private Long price;
    private String company;
    private String keyCap;
    private String keyboardImage;
}
