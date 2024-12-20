package com.example.portfolio.domain.genre;

import com.example.portfolio.domain.base.BaseEntity;
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
    @Column(name = "GENRE_NAME", nullable = false, unique = true)
    private String genreName;

    @Builder
    public GenreEntity(Long genreId, String genreName){
        this.genreId = genreId;
        this.genreName = genreName;
    }
}
