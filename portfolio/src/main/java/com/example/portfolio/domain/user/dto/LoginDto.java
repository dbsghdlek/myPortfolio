package com.example.portfolio.domain.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String loginId;

    @Size(min = 3, max = 50)
    private String userName;

    @NotNull
    @Size(min = 3, max = 100)
    private String passWd;
}
