package com.bancopan.cloud9.bluebank.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //http://localhost:5000/swagger-ui.html

    @Bean
    public Docket bluebankApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bancopan.cloud9.bluebank"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "BLUEBANK - SQUAD CLOUD9",
                "API REST DE UM SISTEMA BANCÁRIO",
                "1.0",
                "terms of service",
                new Contact("JOÃO PEDRO MARQUES, LEANDRO BARROS, LUIZ NASCIMENTO, MARCEL PINOTTI", " github.com/joaopedro-marques, github.com/leandrobarr, github.com/luizns, github.com/marcelpinotti", " "),
                "Apache License Version 2.0",
                "https://www.apache.org/license.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }
}
