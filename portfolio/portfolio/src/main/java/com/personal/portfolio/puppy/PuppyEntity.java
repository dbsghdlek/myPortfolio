package com.personal.portfolio.puppy;

import com.personal.portfolio.domain.base.BaseEntity;
import com.personal.portfolio.menu.MenuEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "PUPPY")
@Getter
@NoArgsConstructor
public class PuppyEntity extends BaseEntity {
    @Id @GeneratedValue
    private Long pictureId;
    @Column(name = "PICTURE_NAME")
    private String pictureName;
    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menu;
    @Builder
    public PuppyEntity(Long pictureId, String pictureName, LocalDateTime createDate, LocalDateTime modifiedDate){
        this.pictureId = pictureId;
        this.pictureName = pictureName;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
