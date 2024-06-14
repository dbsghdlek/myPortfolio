package com.example.portfolio.hobby;

import com.example.portfolio.domain.base.BaseDto;
import lombok.Data;

@Data
public class HobbyDto extends BaseDto {
    private int hobbyId;
    private String hobbyName;

    public HobbyEntity toEntity(){
        return HobbyEntity.builder()
                .hobbyId(hobbyId)
                .hobbyName(hobbyName)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }

    public HobbyDto(HobbyEntity hobbyEntity){
        this.hobbyId = hobbyEntity.getHobbyId();
        this.hobbyName = hobbyEntity.getHobbyName();
        this.createDate = hobbyEntity.getCreateDate();
        this.modifiedDate = hobbyEntity.getModifiedDate();
    }
}
