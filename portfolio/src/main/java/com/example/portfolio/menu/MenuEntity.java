package com.example.portfolio.menu;

import com.example.portfolio.domain.base.BaseEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Slf4j
@Entity
@Table(name = "MENU", uniqueConstraints = {
        @UniqueConstraint(name = "NAME_UNIQUE",
        columnNames = {"MENU_ID","MENU_NAME"})
})
@Getter
@NoArgsConstructor
public class MenuEntity extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID", nullable = false)
    private Long menuId;

    @Column(name = "MENU_NAME", nullable = false, length = 200, unique = true)
    private String menuName;
    @Column(name = "MENU_IMAGE", nullable = true, length = 255)
    private String menuImage;

//    필요한 경우 주석해제하여 사용
//    @OneToMany(mappedBy = "menuEntity")
//    private List<Music> musicEntities = new ArrayList<Music>();
//    @OneToMany(mappedBy = "menuEntity")
//    private List<Hobby> hobbyEntity = new ArrayList<Hobby>();

    @Builder
    public MenuEntity(Long menuId, String menuName, String menuImage, LocalDateTime createDate, LocalDateTime modifiedDate){
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuImage = menuImage;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public boolean valueUpdate(MenuEntity menuEntity){
        try{
            this.menuName = menuEntity.getMenuName();
            this.menuImage = menuEntity.getMenuImage();
            this.modifiedDate = LocalDateTime.now();
        }catch (Exception e){
            log.info("Exception ->" +  e);
            return false;
        }
        return true;
    }
}
