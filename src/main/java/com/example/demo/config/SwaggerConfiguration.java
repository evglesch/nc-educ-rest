package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("DEMO")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "DEMO Swagger REST API",
                "For more info visit https://github.com/evglesch/nc-educ-rest",
                "1.0",
                "",
                new Contact("Evgenii Leshchishin", "", "evgenii.leshchishin@NetCracker.com"),
                "",
                "",
                new ArrayList<>()
        );
    }
}
