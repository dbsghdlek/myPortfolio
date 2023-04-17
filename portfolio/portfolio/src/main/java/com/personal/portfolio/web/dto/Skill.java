package com.personal.portfolio.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Builder
public class Skill {
    @NotEmpty
    private int SkillID;
    @NotEmpty
    private String SkillName;
}
