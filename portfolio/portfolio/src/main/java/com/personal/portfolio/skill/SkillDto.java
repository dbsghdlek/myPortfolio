package com.personal.portfolio.skill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Builder
public class SkillDto {
    @NotEmpty
    private int SkillID;
    @NotEmpty
    private String SkillName;
}
