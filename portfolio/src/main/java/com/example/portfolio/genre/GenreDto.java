package com.example.portfolio.genre;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GenreDto {
    @NotEmpty
    private Long genreId;
    @NotEmpty
    private String genreName;
    public GenreDto(Long genreId, String genreName){
        this.genreId = genreId;
        this.genreName = genreName;
    }
}
