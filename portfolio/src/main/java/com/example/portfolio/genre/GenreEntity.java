package com.example.portfolio.genre;

import com.example.portfolio.domain.base.BaseEntity;
import lombok.Getter;

import jakarta.persistence.*;

@Entity
@Table(name = "Genre")
@Getter
public class GenreEntity extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "GENRE_ID", nullable = false)
    private Long genreId;
    @Column(name = "GENRE_NAME", nullable = false)
    private String genreName;
}
