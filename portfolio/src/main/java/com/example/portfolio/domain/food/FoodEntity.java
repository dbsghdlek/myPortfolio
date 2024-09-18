package com.example.portfolio.domain.food;

import com.example.portfolio.domain.menu.MenuEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Table(name = "Food")
@Slf4j
@NoArgsConstructor
public class FoodEntity {

    @Id
    @GeneratedValue
    @Column(name = "FOOD_ID", nullable = false)
    private Long Id;
    
    // 음식점 이름
    @Column(name = "LESTAURANT")
    private String restaurant;
    // 음식 사진 이름
    @Column(name = "PICTURE_NAME", nullable = false)
    private String pictureName;

    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;

    @Builder
    public FoodEntity(Long id, String restaurant, String pictureName) {
        Id = id;
        this.restaurant = restaurant;
        this.pictureName = pictureName;
    }

    public boolean valueUpdate(FoodDto foodDto){
        try {
            this.restaurant = foodDto.getRestaurant();
            this.pictureName = foodDto.getPictureName();
            return true;
        }catch (Exception e){
            log.error(new StringBuilder().append("FoodValue Update Error : ").append(e).toString());
            return false;
        }
    }
}
