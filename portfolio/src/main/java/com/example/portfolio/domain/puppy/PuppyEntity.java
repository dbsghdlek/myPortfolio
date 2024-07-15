package com.example.portfolio.domain.puppy;

import com.example.portfolio.domain.base.BaseEntity;
import com.example.portfolio.domain.menu.MenuEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PUPPY")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class PuppyEntity extends BaseEntity{
    @Id @GeneratedValue
    private Long pictureId;
    @Column(name = "PICTURE_NAME", nullable = false)
    private String pictureName;
    @Column(name = "PICTURE_DATE")
    private LocalDateTime pictureDate;
    @Column(name = "PUPPY_NAME")
    private String puppyName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;

    @Builder
    public PuppyEntity(Long pictureId, String pictureName, LocalDateTime pictureDate, String puppyName, MenuEntity menuEntity, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.pictureId = pictureId;
        this.pictureName = pictureName;
        this.pictureDate = pictureDate;
        this.puppyName = puppyName;
        this.menuEntity = menuEntity;
        this.createDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
