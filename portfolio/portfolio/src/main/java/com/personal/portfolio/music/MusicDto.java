package com.personal.portfolio.music;

import com.personal.portfolio.domain.base.BaseDto;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MusicDto extends BaseDto {
    @NotEmpty
    private Long musicID;
    @NotEmpty
    private String musicName;

    public MusicDto(MusicEntity musicEntity){
        this.musicID = musicEntity.getMusicID();
        this.musicName = musicEntity.getMusicName();
        this.createDate = musicEntity.getCreateDate();
        this.modifiedDate = musicEntity.getModifiedDate();
    }

    public MusicEntity toEntity(){
        return new MusicEntity().builder()
                .musicID(musicID)
                .musicName(musicName)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }
}
