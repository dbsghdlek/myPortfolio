package com.personal.portfolio.puppy;

import com.personal.portfolio.menu.MenuEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PUPPY")
@Getter
@NoArgsConstructor
public class PuppyEntity {
    @Id @GeneratedValue
    private Long pictureId;
    private String pictureName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menu;
    @Builder
    public PuppyEntity(Long pictureId, String pictureName, Date createDate){
        this.pictureId = pictureId;
        this.pictureName = pictureName;
        this.createDate = createDate;
    }
}
