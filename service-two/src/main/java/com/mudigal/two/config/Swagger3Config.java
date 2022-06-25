package com.mudigal.two.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Swagger configuration
 *
 * @author Vijayendra Mudigal
 */
@Configuration
@ConditionalOnProperty(value = "springfox.documentation.enabled", havingValue = "true", matchIfMissing = true)
public class Swagger3Config {

  @Bean
  public OpenAPI springShopOpenAPI() {
    return new OpenAPI()
        .info(new Info().title("Microservices Sample - Service Two API")
            .description("API documentation for service two service with h2/mysql database")
            .contact((new Contact().name("Mudigal Technologie LLP")
                .email("contact@mudigal.com")
                .url("https://www.mudigal.com")))
            .version("1.0.0")
            .version("v5.0.0")
            .license(new License().name("Apache 2.0")))
        .externalDocs(new ExternalDocumentation()
            .description("Microservices Sample")
            .url("https://www.github.com/mudigal-technologies/microservices-sample"));
  }

}