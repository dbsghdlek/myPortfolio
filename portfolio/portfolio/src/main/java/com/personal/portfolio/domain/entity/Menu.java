package com.personal.portfolio.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;



@Entity
@Table(name = "MENU", uniqueConstraints = {
        @UniqueConstraint(name = "NAME_UNIQUE",
        columnNames = {"MENU_ID","MENU_NAME"})
})
public class Menu {
    @Id @GeneratedValue
    @Column(name = "MENU_ID", nullable = false)
    private int menuId;

    @Column(name = "MENU_NAME", nullable = false, length = 200)
    private String menuName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @ManyToOne
    @JoinColumn(name = "MUSIC_ID")
    private Music music;

}
