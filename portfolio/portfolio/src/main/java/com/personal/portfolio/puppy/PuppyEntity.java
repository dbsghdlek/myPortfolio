package com.personal.portfolio.puppy;

import com.personal.portfolio.domain.base.BaseEntity;
import com.personal.portfolio.menu.MenuEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PUPPY")
@Getter
@NoArgsConstructor
public class PuppyEntity extends BaseEntity {
    @Id @GeneratedValue
    private Long pictureId;
    @Column(name = "PICTURE_NAME", nullable = false)
    private String pictureName;
    @Column(name = "PICTURE_DATE", nullable = false)
    private LocalDateTime pictureDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;
    @Builder
    public PuppyEntity(Long pictureId, String pictureName, LocalDateTime pictureDate, LocalDateTime createDate, LocalDateTime modifiedDate){
        this.pictureId = pictureId;
        this.pictureName = pictureName;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.pictureDate = pictureDate;
    }
}
