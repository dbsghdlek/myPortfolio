package com.personal.portfolio.genre;

import com.personal.portfolio.domain.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "Genre")
public class GenreEntity extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "GENRE_ID", nullable = false)
    private Long genreId;
    @Column(name = "GENRE_NAME", nullable = false)
    private String genreName;
}
