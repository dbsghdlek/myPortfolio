package com.example.portfolio.music.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MusicAndGenre {
    @NotEmpty
    private Long musicID;
    @NotEmpty
    private String musicName;
    private String musicImage;
    private String singerName;
    private Long genreId;
    private String genreName;
}
