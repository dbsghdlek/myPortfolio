package com.example.portfolio.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "내 포트폴리오 API 명세서",
                description = "내 포트폴리오 API 명세서",
                version = "v1"))
@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = {"/v1/**"};

        return GroupedOpenApi.builder()
                .group("내 포트폴리오 API v1")
                .pathsToMatch(paths)
                .build();
    }
}
