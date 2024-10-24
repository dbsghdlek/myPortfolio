package com.example.portfolio.domain.music.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@ToString
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
