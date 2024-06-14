package com.example.portfolio.music;

import com.example.portfolio.domain.base.BaseDto;
import lombok.*;

import jakarta.validation.constraints.NotEmpty;

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

    public MusicDto(MusicEntity musicEntity){
        this.musicID = musicEntity.getMusicID();
        this.musicName = musicEntity.getMusicName();
        this.createDate = musicEntity.getCreateDate();
        this.modifiedDate = musicEntity.getModifiedDate();
        this.singerName = musicEntity.getSingerName();
    }

    public MusicEntity toEntity(){
        return new MusicEntity().builder()
                .musicID(musicID)
                .musicName(musicName)
                .singerName(singerName)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }
}
