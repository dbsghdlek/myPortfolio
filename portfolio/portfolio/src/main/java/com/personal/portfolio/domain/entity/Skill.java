package com.personal.portfolio.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class Skill {
    @NotEmpty
    private int SkillID;
    @NotEmpty
    private String SkillName;
}
