package com.example.portfolio.domain.travel;

import com.example.portfolio.domain.base.BaseEntity;
import com.example.portfolio.domain.menu.MenuEntity;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "Travel")
public class TravelEntity extends BaseEntity {

    @Id
    @Column(name = "TRAVEL_ID")
    private Long Id;

    private String travelPictureName;

    private String location;

    private Date pictureDate;

    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;
}
