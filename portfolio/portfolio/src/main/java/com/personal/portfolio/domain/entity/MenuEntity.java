package com.personal.portfolio.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "MENU", uniqueConstraints = {
        @UniqueConstraint(name = "NAME_UNIQUE",
        columnNames = {"MENU_ID","MENU_NAME"})
})
@Getter
public class MenuEntity {
    @Id @GeneratedValue
    @Column(name = "MENU_ID", nullable = false)
    private int menuId;

    @Column(name = "MENU_NAME", nullable = false, length = 200)
    private String menuName;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @OneToMany(mappedBy = "menuEntity")
    private List<MusicEntity> musicEntities = new ArrayList<MusicEntity>();
    @OneToMany(mappedBy = "menuEntity")
    private List<HobbyEntity> hobbyEntity = new ArrayList<HobbyEntity>();
}
