package com.jdxm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by PK on 2019/3/22.
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jdxm"))
                .paths(PathSelectors.any())
                .build();
    }

    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("机电项目swagger文档")
                .description("机电项目swagger文档")
                .termsOfServiceUrl("")
                .contact("jdxm")
                .version("1.0")
                .build();
    }
}