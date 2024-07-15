package com.example.portfolio.keyboard;

import com.example.portfolio.domain.base.BaseEntity;
import com.example.portfolio.hobby.HobbyEntity;
import lombok.Getter;

import jakarta.persistence.*;

@Entity
@Table(name = "KEYBOARD")
@Getter
public class KeyboardEntity extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "KEYBOARD_ID")
    private Long keyboardId;
    @Column(name = "REINFORCE_PLATE")
    private String reinforcePlate;
    @Column(name = "PRICE")
    private Long price;
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "KEY_CAP")
    private String keyCap;
    @Column(name = "KEYBOARD_IMAGE")
    private String keyboardImage;
    @ManyToOne
    @JoinColumn(name = "HOBBY_ID")
    private HobbyEntity hobbyEntity;
}
