package com.personal.portfolio.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Skill {
    @Id
    @Column(name = "SKILL_ID")
    private int SkillID;
    @Column(name = "SKILL_NAME")
    private String SkillName;
}
