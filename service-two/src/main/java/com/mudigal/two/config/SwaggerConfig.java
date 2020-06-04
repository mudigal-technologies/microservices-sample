package com.mudigal.two.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration
 *
 * @author Vijayendra Mudigal
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.mudigal.two")).paths(PathSelectors.any())
        .build()
        .apiInfo(generateApiInfo());
  }

  private ApiInfo generateApiInfo() {
    return new ApiInfo("Microservices Sample - Service Two",
        "API documentation for service two service with h2/mysql database", "5.0.0", "",
        new Contact("Vijayendra Mudigal", "https://vijayendra.mudigal.com",
            "vijayendrap@gmail.com"), "Apache License 2.0", "#",
        Collections.emptyList());
  }

}