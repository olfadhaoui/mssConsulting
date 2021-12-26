package com.olfa.msproduit.swagger;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author olfa dhaoui
 *
 *
 */
@Configuration
public class SwaggerConfiguration {
    public Docket cloneApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(getInfoApi());
    }

    private ApiInfo getInfoApi() {
        return new ApiInfoBuilder()
                .title("api")
                .version("8.8.1")
                .description("info sur produits")
                .contact(new Contact("olfa","","olfa@gmail.com"))
                .license("0.0.1")
                .build();
    }
}
