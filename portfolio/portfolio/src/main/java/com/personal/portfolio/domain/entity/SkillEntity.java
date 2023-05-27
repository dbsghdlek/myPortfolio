package com.personal.portfolio.domain.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class SkillEntity {
    @Id
    @Column(name = "SKILL_ID")
    private int SkillID;
    @Column(name = "SKILL_NAME")
    private String SkillName;
}
