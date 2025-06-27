package br.com.viniciussouza.spring_boot_rest_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot REST API")
                        .version("v1")
                        .description("REST API's RESTful com Spring Boot, Kubernetes, Docker e AWS")
                );
    }
}
