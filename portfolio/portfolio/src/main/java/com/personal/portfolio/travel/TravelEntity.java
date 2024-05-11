package com.personal.portfolio.travel;

import com.personal.portfolio.domain.base.BaseEntity;
import com.personal.portfolio.menu.MenuEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Travel")
public class TravelEntity extends BaseEntity {
    @Id
    private Long travelId;

    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;
}
