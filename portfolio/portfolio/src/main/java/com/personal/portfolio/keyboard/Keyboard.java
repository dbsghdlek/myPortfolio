package com.personal.portfolio.keyboard;

import com.personal.portfolio.domain.base.BaseEntity;
import com.personal.portfolio.hobby.Hobby;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "KEYBOARD")
@Getter
public class Keyboard extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "KEYBOARD_ID")
    private int keyboardId;
    @Column(name = "REINFORCE_PLATE")
    private String reinforcePlate;
    @Column(name = "PRICE")
    private int price;
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "KEY_CAP")
    private String keyCap;
    @Column(name = "KEYBOARD_IMAGE")
    private String keyboardImage;
    @ManyToOne
    @JoinColumn(name = "HOBBY_ID")
    private Hobby hobby;
}
