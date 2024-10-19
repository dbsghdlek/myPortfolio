package com.example.portfolio.domain.food.dto;

import com.example.portfolio.domain.food.entity.FoodEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {
    @NotEmpty
    private Long Id;
    // 음식점 이름
    private String restaurant;
    // 음식 사진 이름
    @NotEmpty
    private String pictureName;

    public FoodEntity toEntity(){
        return FoodEntity.builder()
                .id(this.Id)
                .restaurant(this.restaurant)
                .pictureName(this.pictureName)
                .build();
    }

    public FoodDto(FoodEntity food){
        this.Id = food.getId();
        this.restaurant = food.getRestaurant();
        this.pictureName = food.getPictureName();
    }
}
