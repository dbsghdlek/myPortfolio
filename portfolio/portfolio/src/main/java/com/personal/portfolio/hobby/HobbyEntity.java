package com.personal.portfolio.hobby;

import com.personal.portfolio.keyboard.KeyboardEntity;
import com.personal.portfolio.menu.MenuEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "HOBBY")
@Getter
public class HobbyEntity {
    @Id @GeneratedValue
    @Column(name = "HOBBY_ID")
    private int hobbyId;
    @Column(name = "HOBBY_NAME")
    private String hobbyName;
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Column(name = "DELETE_DATE")
    private String deleteDate;
    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;
    @OneToMany(mappedBy = "hobbyEntity")
    private List<KeyboardEntity> keyboard;
    @Builder
    public HobbyEntity(int hobbyId, String hobbyName, String createDate, String deleteDate){
        this.hobbyId = hobbyId;
        this.hobbyName = hobbyName;
        this.createDate = createDate;
        this.deleteDate = deleteDate;
    }

    public void valueUpdate(HobbyDto hobbyDto){
        this.hobbyName = hobbyDto.getHobbyName();
        this.createDate = hobbyDto.getCreateDate();
        this.deleteDate = hobbyDto.getDeleteDate();
    }
}
