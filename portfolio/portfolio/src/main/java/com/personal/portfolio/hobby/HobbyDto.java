package com.personal.portfolio.hobby;

import lombok.Data;

import javax.persistence.Column;

@Data
public class HobbyDto {
    private int hobbyId;
    private String hobbyName;
    private String createDate;
    private String deleteDate;

    public HobbyEntity toEntity(){
        return HobbyEntity.builder()
                .hobbyId(hobbyId)
                .hobbyName(hobbyName)
                .createDate(createDate)
                .deleteDate(deleteDate)
                .build();
    }

    public HobbyDto(HobbyEntity hobbyEntity){
        this.hobbyId = hobbyEntity.getHobbyId();
        this.hobbyName = hobbyEntity.getHobbyName();
        this.createDate = hobbyEntity.getCreateDate();
        this.deleteDate = hobbyEntity.getDeleteDate();
    }
}
