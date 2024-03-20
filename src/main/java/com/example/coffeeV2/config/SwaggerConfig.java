package com.example.coffeeV2.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info()
                .title("Spring Boot Coffee Shop API REST")
                .version("1.0")
                .description("Coffee Shop API REST DOCS")
                .termsOfService("http://google.com"));
    }

}
