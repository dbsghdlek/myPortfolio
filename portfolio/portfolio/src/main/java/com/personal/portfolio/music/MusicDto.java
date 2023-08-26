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

    private GenreEnum genre;
    @NotEmpty
    private String singerName;

    public MusicDto(MusicEntity musicEntity){
        this.musicID = musicEntity.getMusicID();
        this.musicName = musicEntity.getMusicName();
        this.genre = musicEntity.getGenre();
        this.createDate = musicEntity.getCreateDate();
        this.modifiedDate = musicEntity.getModifiedDate();
        this.singerName = musicEntity.getSingerName();
    }

    public MusicEntity toEntity(){
        return new MusicEntity().builder()
                .musicID(musicID)
                .musicName(musicName)
                .genre(genre)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
    }
}
