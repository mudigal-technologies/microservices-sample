package com.mudigal.one.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

/**
 * Swagger configuration
 *
 * @author vijmudig
 *
 */
@Configuration
@EnableSwagger2WebFlux
@Profile("default")
class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.mudigal.one"))
        .paths(PathSelectors.any()).build().apiInfo(apiInfo())
        .useDefaultResponseMessages(false);
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Microservices Sample - Service One").description(
        "API documentation for service one reactive service with mongo database")
                .termsOfServiceUrl("#")
        .contact(new Contact("Vijayendra Mudigal", "https://vijayendra.mudigal.com", "vijayendrap@gmail.com.com"))
        .license("Apache License 2.0")
        .licenseUrl("#").version("5.0.0")
        .build();
  }
}