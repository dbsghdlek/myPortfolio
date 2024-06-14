package com.example.portfolio.travel;

import com.example.portfolio.domain.base.BaseEntity;
import com.example.portfolio.menu.MenuEntity;

import jakarta.persistence.*;

@Entity(name = "Travel")
public class TravelEntity extends BaseEntity {
    @Id
    private Long travelId;

    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;
}
