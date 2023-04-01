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
        columnNames = {"menuID","menuName"})
})
public class Menu {
    @Id @GeneratedValue
    @NonNull
    @Column(name = "menuID", nullable = false)
    private int menuId;

    @Column(name = "menuName", nullable = false, length = 200)
    private String menuName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
}
