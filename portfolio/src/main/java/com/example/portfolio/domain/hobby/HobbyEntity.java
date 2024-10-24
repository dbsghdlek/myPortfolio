package com.example.portfolio.domain.hobby;

import com.example.portfolio.domain.base.BaseEntity;
import com.example.portfolio.domain.menu.MenuEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "HOBBY")
@Getter
@NoArgsConstructor
public class HobbyEntity extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "HOBBY_ID")
    private int hobbyId;
    @Column(name = "HOBBY_NAME")
    private String hobbyName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    private MenuEntity menuEntity;

//    필요한 경우 주석해제하여 사용
//    @OneToMany(mappedBy = "hobbyEntity")
//    private List<Keyboard> keyboard;
    @Builder
    public HobbyEntity(int hobbyId, String hobbyName, LocalDateTime createDate, LocalDateTime modifiedDate){
        this.hobbyId = hobbyId;
        this.hobbyName = hobbyName;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public void valueUpdate(HobbyDto hobbyDto) throws IllegalArgumentException{
        this.hobbyName = hobbyDto.getHobbyName();
        this.createDate = hobbyDto.getCreateDate();
        this.modifiedDate = hobbyDto.getModifiedDate();
    }
}
