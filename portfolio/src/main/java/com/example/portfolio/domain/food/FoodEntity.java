package com.example.portfolio.domain.food;

import com.example.portfolio.domain.menu.MenuEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Food")
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
}
