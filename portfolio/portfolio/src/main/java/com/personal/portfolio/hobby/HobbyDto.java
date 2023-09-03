package com.personal.portfolio.hobby;

import com.personal.portfolio.domain.base.BaseDto;
import lombok.Data;

@Data
public class HobbyDto extends BaseDto {
    private int hobbyId;
    private String hobbyName;

    public Hobby toEntity(){
        return Hobby.builder()
                .hobbyId(hobbyId)
                .hobbyName(hobbyName)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }

    public HobbyDto(Hobby hobby){
        this.hobbyId = hobby.getHobbyId();
        this.hobbyName = hobby.getHobbyName();
        this.createDate = hobby.getCreateDate();
        this.modifiedDate = hobby.getModifiedDate();
    }
}
