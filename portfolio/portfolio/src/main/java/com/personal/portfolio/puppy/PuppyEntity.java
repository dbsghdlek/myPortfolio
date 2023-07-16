package com.personal.portfolio.puppy;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PUPPY")
@Getter
@NoArgsConstructor
public class PuppyEntity {
    @Id @GeneratedValue
    private Long pictureId;
    private String pictureName;
    private Date createDate;
    @Builder
    public PuppyEntity(Long pictureId, String pictureName, Date createDate){
        this.pictureId = pictureId;
        this.pictureName = pictureName;
        this.createDate = createDate;
    }
}
