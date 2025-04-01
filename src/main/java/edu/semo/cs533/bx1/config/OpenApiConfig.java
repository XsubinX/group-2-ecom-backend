package edu.semo.cs533.bx1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Group 2 E-Commerce backend API")
                        .version("0.0.1-SNAPSHOT")
                        .description("Spring 2025 CS533-BX1 Mobile Computing 25412")
                        .contact(new Contact()
                                .name("Mobile Computing Group 2")
                                .url("https://semo.instructure.com/groups/16265")
                                .email("ssugandhamanysugun1s@semo.edu"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                );
    }
}
