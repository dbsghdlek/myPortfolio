package com.personal.portfolio.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HOBBY")
@Getter
public class HobbyEntity {
    @Id @GeneratedValue
    @Column(name = "HOBBY_ID")
    private int hobbyId;
    @Column(name = "HOBBY_NAME")
    private String hobbyName;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "DELETE_DATE")
    private Date deleteDate;
    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;
//    @OneToMany(mappedBy = "keyboardId")
//    private Keyboard keyboard;
}
