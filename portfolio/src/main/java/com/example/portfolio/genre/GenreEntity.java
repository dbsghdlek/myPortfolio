package com.example.portfolio.genre;

import com.example.portfolio.domain.base.BaseEntity;
import com.example.portfolio.music.MusicEntity;
import lombok.Builder;
import lombok.Getter;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Genre")
@Getter
@NoArgsConstructor
public class GenreEntity extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "GENRE_ID", nullable = false)
    private Long genreId;
    @Column(name = "GENRE_NAME", nullable = false)
    private String genreName;

    @Builder
    public GenreEntity(Long genreId, String genreName){
        this.genreId = genreId;
        this.genreName = genreName;
    }
}
