package com.personal.portfolio.music;

import com.personal.portfolio.domain.base.BaseDto;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MusicDto extends BaseDto {
    @NotEmpty
    private Long musicID;
    @NotEmpty
    private String musicName;
    @NotEmpty
    private String singerName;

    public MusicDto(Music music){
        this.musicID = music.getMusicID();
        this.musicName = music.getMusicName();
        this.createDate = music.getCreateDate();
        this.modifiedDate = music.getModifiedDate();
        this.singerName = music.getSingerName();
    }

    public Music toEntity(){
        return new Music().builder()
                .musicID(musicID)
                .musicName(musicName)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }
}
