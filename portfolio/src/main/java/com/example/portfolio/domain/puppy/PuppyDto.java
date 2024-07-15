package com.example.portfolio.domain.puppy;

import com.example.portfolio.domain.base.BaseDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PuppyDto extends BaseDto {

    private Long pictureId;

    private String puppyName;

    private String pictureName;

    private LocalDateTime pictureDate;

    public PuppyEntity toEntity(){
        return PuppyEntity.builder()
                .pictureId(pictureId)
                .pictureName(pictureName)
                .puppyName(puppyName)
                .pictureDate(pictureDate)
                .createdDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }
}
