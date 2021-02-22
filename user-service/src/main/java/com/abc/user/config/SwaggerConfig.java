package com.abc.user.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.abc.order"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(userApiInfo());

    }

    private ApiInfo userApiInfo() {
        return new ApiInfoBuilder().title("Spring Boot REST API")
                .description("Order Service REST API")
                .license("ZeroBeta")
                .licenseUrl("https://zerobeta.com")
                .version("0.0.1")
                .build();

    }
}
