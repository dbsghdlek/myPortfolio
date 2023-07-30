package com.personal.portfolio.hobby;

import com.personal.portfolio.domain.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class HobbyDto extends BaseEntity {
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
