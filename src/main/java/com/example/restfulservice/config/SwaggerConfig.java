package com.example.restfulservice.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "My Restful Service API 명세서",
                    description = "Spring Boot로 개발하는 RESTful API 명세서입니다",
                    version = "1.0.0")
)
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi customTestOpenAPI(){
        String[] paths = {"/users/**","/admin/**"};

        // 모든 api가 전부 노출되는것이 아닌 일부만 공개시킬 수 있다.
        return GroupedOpenApi.builder()
                .group("일반 사용자와 관리자를 위한 User 도메인에 대한 API")
                .pathsToMatch(paths)
                .build();
    }
}
