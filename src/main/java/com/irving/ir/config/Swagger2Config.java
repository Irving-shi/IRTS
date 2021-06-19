package com.irving.ir.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author irving
 * @date 2021/6/10
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
//    @Bean
//    public Docket createRestApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                //为当前包下controller生成API文档
//                .apis(RequestHandlerSelectors.basePackage("com.irving.ir.controller"))
//                //为有@Api注解的Controller生成API文档
////                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                //为有@ApiOperation注解的方法生成API文档
////                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build()
//                ;
//    }

    @Bean(value = "defaultApi")
    public Docket defaultApi() {
        List<Parameter> pars = new ArrayList<Parameter>();

        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("token").description("令牌")
                .modelRef(new ModelRef("String")).parameterType("header")
                .required(true).build(); //header中的Token参数必填，但是这里不能解决部分接口不需要token参数

        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.irving.ir.controller.auth"))
                .paths(PathSelectors.any())
                .build().groupName("需要token验证接口").globalOperationParameters(pars).ignoredParameterTypes(HttpServletResponse.class, HttpServletRequest.class);
    }

    @Bean(value = "publicApi")
    public Docket publicApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.irving.ir.controller.pub"))
                .paths(PathSelectors.any())
                .build().groupName("无需token验证接口").ignoredParameterTypes(HttpServletResponse.class, HttpServletRequest.class);

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI演示")
                .description("问答系统接口文档")
                .contact("corpus")
                .version("1.0")
                .build();
    }



}
