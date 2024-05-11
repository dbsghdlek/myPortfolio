package com.personal.portfolio.keyboard;

import com.personal.portfolio.domain.base.BaseEntity;
import com.personal.portfolio.hobby.HobbyEntity;
import lombok.Getter;

import javax.persistence.*;

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
