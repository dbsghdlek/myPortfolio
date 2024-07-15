package com.example.portfolio.domain.hobby;

import com.example.portfolio.domain.base.BaseDto;
import lombok.Builder;
import lombok.Data;

@Data
public class HobbyDto extends BaseDto {
    private int hobbyId;
    private String hobbyName;

    public HobbyEntity toEntity(){
        return HobbyEntity.builder()
                .hobbyName(hobbyName)
                .build();
    }

    @Builder
    public HobbyDto(String hobbyName){
        this.hobbyName = hobbyName;
    }

    public HobbyDto(HobbyEntity hobbyEntity){
        this.hobbyId = hobbyEntity.getHobbyId();
        this.hobbyName = hobbyEntity.getHobbyName();
        this.createDate = hobbyEntity.getCreateDate();
        this.modifiedDate = hobbyEntity.getModifiedDate();
    }
}
