package com.personal.portfolio.genre;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "GENRE")
public class Genre {
    @Id @GeneratedValue
    @Column(name = "GENRE_NO")
    private int genreNo;
    @Column(name = "GENRE_NAME", unique = true)
    private String genreName;
}
