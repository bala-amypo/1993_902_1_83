package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration   // 🔹 Annotation to mark this as a config class
public class OpenApiConfig {

    @Bean   // 🔹 Registers this method as a Spring Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Demo API")
                        .description("Demo Spring Boot Application APIs")
                        .version("1.0.0")
                )
                .servers(List.of(
                        new Server().url("http://localhost:9008")
                ));
    }
}
