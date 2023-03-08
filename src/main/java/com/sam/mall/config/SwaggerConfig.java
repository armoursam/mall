package com.sam.mall.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger2API文档的配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        Predicate<RequestHandler> requestHandlerPredicate = RequestHandlerSelectors.basePackage("com.sam.mall.controller");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //设置api文档的分组
                .groupName("Sam")
                .select()
                //为当前包下controller生成API文档
                .apis(requestHandlerPredicate)
                //为有@Api注解的Controller生成API文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths((Predicate<String>) PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI演示")
                .description("mall")
                .contact(new Contact("Sam","https//:localhost:8080","179474332@qq.com"))
                .version("1.0")
                .build();
    }
}