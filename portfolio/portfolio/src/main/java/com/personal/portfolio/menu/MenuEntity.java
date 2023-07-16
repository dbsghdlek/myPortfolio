package com.personal.portfolio.menu;

import com.personal.portfolio.hobby.HobbyEntity;
import com.personal.portfolio.music.MusicEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Entity
@Table(name = "MENU", uniqueConstraints = {
        @UniqueConstraint(name = "NAME_UNIQUE",
        columnNames = {"MENU_ID","MENU_NAME"})
})
@Getter
@NoArgsConstructor
public class MenuEntity {
    @Id @GeneratedValue
    @Column(name = "MENU_ID", nullable = false)
    private int menuId;

    @Column(name = "MENU_NAME", nullable = false, length = 200)
    private String menuName;

    @Column(name = "CREATE_DATE", nullable = false, length = 60)
    private Date createDate;
    @OneToMany(mappedBy = "menuEntity")
    private List<MusicEntity> musicEntities = new ArrayList<MusicEntity>();
    @OneToMany(mappedBy = "menuEntity")
    private List<HobbyEntity> hobbyEntity = new ArrayList<HobbyEntity>();

    @Builder
    public MenuEntity(int menuId, String menuName, Date createDate){
        this.menuId = menuId;
        this.menuName = menuName;
        this.createDate = createDate;
    }

    public boolean valueUpdate(MenuEntity menuEntity){
        try{
            this.menuId = menuEntity.getMenuId();
            this.menuName = menuEntity.getMenuName();
        }catch (Exception e){
            log.info("Exception ->" +  e);
            return false;
        }
        return true;
    }
}
