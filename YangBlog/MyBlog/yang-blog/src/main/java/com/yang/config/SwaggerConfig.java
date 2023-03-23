package com.yang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Description: Swagger文档信息配置类
 * @Author: Mr.Yang
 * @Date: 2023/2/19 23:26
 * @Version: 1.0
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yang.com.yang.controller"))
                .build();

    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("YL", "https://y-orangecat.github.io/", "1249650491@qq.com");
        return new ApiInfoBuilder()
                .title("博客前台Swagger文档")
                .description("该文档对博客前台各接口进行说明")
                //联系方式
                .contact(contact)
                //版本信息
                .version("1.0")
                .build();
    }
}
