package com.personal.portfolio.puppy;

import com.personal.portfolio.domain.base.BaseDto;
import com.personal.portfolio.domain.base.BaseEntity;



public class PuppyDto extends BaseDto {

    private Long pictureId;

    private String pictureName;


    public PuppyEntity toEntity(){
        return new PuppyEntity().builder()
                .pictureId(pictureId)
                .pictureName(pictureName)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }

    public PuppyDto(PuppyEntity puppyEntity){
        this.pictureId = puppyEntity.getPictureId();
        this.pictureName = puppyEntity.getPictureName();
        this.createDate = puppyEntity.getCreateDate();
        this.modifiedDate = puppyEntity.getModifiedDate();
    }
}
