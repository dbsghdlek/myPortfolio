package com.example.portfolio.food;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class FoodDto {
    @NotEmpty
    private Long Id;
    // 음식점 이름
    private String restaurant;
    // 음식 사진 이름
    @NotEmpty
    private String pictureName;
}
