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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID", nullable = false)
    private Long menuId;

    @Column(name = "MENU_NAME", nullable = false, length = 200)
    private String menuName;
    @Column(name = "MENU_IMAGE", nullable = true, length = 255)
    private String menuImage;
    @Column(name = "CREATE_DATE", nullable = false, length = 60)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

//    필요한 경우 주석해제하여 사용
//    @OneToMany(mappedBy = "menuEntity")
//    private List<MusicEntity> musicEntities = new ArrayList<MusicEntity>();
//    @OneToMany(mappedBy = "menuEntity")
//    private List<HobbyEntity> hobbyEntity = new ArrayList<HobbyEntity>();

    @Builder
    public MenuEntity(Long menuId, String menuName, String menuImage, Date createDate){
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuImage = menuImage;
        this.createDate = createDate;
    }

    public boolean valueUpdate(MenuEntity menuEntity){
        try{
            this.menuId = menuEntity.getMenuId();
            this.menuName = menuEntity.getMenuName();
            this.menuImage = menuEntity.getMenuImage();
        }catch (Exception e){
            log.info("Exception ->" +  e);
            return false;
        }
        return true;
    }
}
