package com.personal.portfolio.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class MusicEntity {
    @NotEmpty
    @NonNull
    @Id
    private int MusicID;
    @NotEmpty
    @NonNull
    private String MusinName;
    private Date CreateDate;
    private Date DeleteDate;
    @NotEmpty
    @NonNull
    private int SingerID;

}
