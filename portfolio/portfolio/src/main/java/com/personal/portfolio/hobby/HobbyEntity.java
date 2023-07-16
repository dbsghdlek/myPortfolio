package com.personal.portfolio.hobby;

import com.personal.portfolio.keyboard.KeyboardEntity;
import com.personal.portfolio.menu.MenuEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "HOBBY")
@Getter
@NoArgsConstructor
public class HobbyEntity {
    @Id @GeneratedValue
    @Column(name = "HOBBY_ID")
    private int hobbyId;
    @Column(name = "HOBBY_NAME")
    private String hobbyName;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "DELETE_DATE")
    private Date deleteDate;
    @ManyToOne
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;
    @OneToMany(mappedBy = "hobbyEntity")
    private List<KeyboardEntity> keyboard;
    @Builder
    public HobbyEntity(int hobbyId, String hobbyName, Date createDate, Date deleteDate){
        this.hobbyId = hobbyId;
        this.hobbyName = hobbyName;
        this.createDate = createDate;
        this.deleteDate = deleteDate;
    }

    public void valueUpdate(HobbyDto hobbyDto) throws IllegalArgumentException{
        this.hobbyName = hobbyDto.getHobbyName();
        this.createDate = hobbyDto.getCreateDate();
        this.deleteDate = hobbyDto.getDeleteDate();
    }
}
