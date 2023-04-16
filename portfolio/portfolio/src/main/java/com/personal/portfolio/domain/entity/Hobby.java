package com.personal.portfolio.domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HOBBY")
public class Hobby {
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
    private Menu menu;
//    @OneToMany(mappedBy = "keyboardId")
//    private Keyboard keyboard;
}
