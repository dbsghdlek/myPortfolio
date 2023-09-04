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
    private Genre genre;
    public MusicDto(Music music){
        this.musicID = music.getMusicID();
        this.musicName = music.getMusicName();
        this.createDate = music.getCreateDate();
        this.genre = music.getGenre();
        this.modifiedDate = music.getModifiedDate();
        this.singerName = music.getSingerName();
    }

    public Music toEntity(){
        return new Music().builder()
                .musicID(musicID)
                .musicName(musicName)
                .genre(genre)
                .singerName(singerName)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }
}
