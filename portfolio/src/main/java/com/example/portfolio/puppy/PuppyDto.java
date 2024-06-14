package com.example.portfolio.puppy;

import com.example.portfolio.domain.base.BaseDto;

import java.time.LocalDateTime;


public class PuppyDto extends BaseDto {

    private Long pictureId;

    private String pictureName;

    private LocalDateTime pictureDate;

    public PuppyEntity toEntity(){
        return new PuppyEntity().builder()
                .pictureId(pictureId)
                .pictureName(pictureName)
                .pictureDate(pictureDate)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }

    public PuppyDto(PuppyEntity puppyEntity){
        this.pictureId = puppyEntity.getPictureId();
        this.pictureName = puppyEntity.getPictureName();
        this.pictureDate = puppyEntity.getPictureDate();
        this.createDate = puppyEntity.getCreateDate();
        this.modifiedDate = puppyEntity.getModifiedDate();
    }
}
