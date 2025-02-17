package com.smartwave.vendormanagement.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi vendorApi() {
        return GroupedOpenApi.builder()
                .group("vendor-api")
                .pathsToMatch("/api/vendors/**")
                .build();
    }
}
