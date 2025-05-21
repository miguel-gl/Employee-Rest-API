package com.employees.api.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: SwaggerConfig.
 * Date: 2025-05-21
 * Version: 1.0
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI employeeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("REST API Service of Employees")
                    .description("Employee service management documentation")
                    .version("1.0.0"));
    }
    
}
