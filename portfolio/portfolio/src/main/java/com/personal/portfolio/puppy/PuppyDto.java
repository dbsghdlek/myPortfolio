package com.personal.portfolio.puppy;

import com.personal.portfolio.domain.base.BaseDto;

import java.time.LocalDateTime;


public class PuppyDto extends BaseDto {

    private Long pictureId;

    private String pictureName;

    private LocalDateTime pictureDate;

    public Puppy toEntity(){
        return new Puppy().builder()
                .pictureId(pictureId)
                .pictureName(pictureName)
                .pictureDate(pictureDate)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }

    public PuppyDto(Puppy puppy){
        this.pictureId = puppy.getPictureId();
        this.pictureName = puppy.getPictureName();
        this.pictureDate = puppy.getPictureDate();
        this.createDate = puppy.getCreateDate();
        this.modifiedDate = puppy.getModifiedDate();
    }
}
