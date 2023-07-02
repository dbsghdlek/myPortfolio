package com.personal.portfolio.music;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MusicDto {
    @NotEmpty
    private int musicID;
    @NotEmpty
    private String musicName;
    private String createDate;
    private String deleteDate;

    public MusicDto(MusicEntity musicEntity){
        this.musicID = musicEntity.getMusicID();
        this.musicName = musicEntity.getMusicName();
    }

    public MusicEntity toEntity(){
        return new MusicEntity().builder()
                .musicID(musicID)
                .musicName(musicName)
                .createDate(createDate)
                .deleteDate(deleteDate)
                .build();
    }
}
