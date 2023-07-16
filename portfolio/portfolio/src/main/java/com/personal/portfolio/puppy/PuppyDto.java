package com.personal.portfolio.puppy;

import java.util.Date;

public class PuppyDto {

    private Long pictureId;

    private String pictureName;

    private Date createDate;

    public PuppyEntity toEntity(){
        return new PuppyEntity().builder()
                .pictureId(pictureId)
                .pictureName(pictureName)
                .createDate(createDate)
                .build();
    }

    public PuppyDto(PuppyEntity puppyEntity){
        this.pictureId = puppyEntity.getPictureId();
        this.pictureName = puppyEntity.getPictureName();
        this.createDate = puppyEntity.getCreateDate();
    }
}
