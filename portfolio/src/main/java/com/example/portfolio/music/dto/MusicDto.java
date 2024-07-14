package com.example.portfolio.music.dto;

import com.example.portfolio.domain.base.BaseDto;
import com.example.portfolio.genre.GenreDto;
import com.example.portfolio.music.MusicEntity;
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

    private String musicImage;

    public MusicDto(MusicEntity musicEntity){
        this.musicID = musicEntity.getMusicID();
        this.musicName = musicEntity.getMusicName();
        this.musicImage = musicEntity.getMusicImage();
        this.createDate = musicEntity.getCreateDate();
        this.modifiedDate = musicEntity.getModifiedDate();
        this.singerName = musicEntity.getSingerName();
    }

    public MusicEntity toEntity(){
        return new MusicEntity().builder()
                .musicName(musicName)
                .singerName(singerName)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }
}
