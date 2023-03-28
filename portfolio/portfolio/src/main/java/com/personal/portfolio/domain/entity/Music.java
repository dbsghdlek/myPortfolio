package com.personal.portfolio.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Music {
    @NotEmpty
    @NonNull
    @Id
    private int musicID;
    @NotEmpty
    @NonNull
    private String musicName;
    private Date createDate;
    private Date deleteDate;
    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    private Singer singer;

}