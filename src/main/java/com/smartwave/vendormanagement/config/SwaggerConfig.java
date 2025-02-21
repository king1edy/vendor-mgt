package com.smartwave.vendormanagement.config;

import org.springdoc.core.models.GroupedOpenApi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
//public class SwaggerConfig {
//    @Bean
//    public GroupedOpenApi vendorApi() {
//        return GroupedOpenApi.builder()
//                .group("vendor-api")
//                .pathsToMatch("/api/vendors/**")
//                .build();
//    }
//}


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI vendorManagementAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vendor Management API")
                        .description("API for managing vendors, statuses, and documents")
                        .version("1.0"));
    }
}
