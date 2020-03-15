package com.rainy.property.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * 配置swagger
 * @author 34789
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket (Environment environment){
        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("application");
        //通过boolean确定是否开启Swagger
        boolean b = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //enable  true可以网页进入Swagger,false相反
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rainy.property.controller"))
                .build();

    }

    private ApiInfo apiInfo(){


        Contact contact = new Contact("Rainy", "https://github.com/347890208", "347890208@qq.com");
        return new ApiInfo(
                "property_bishe",
                "Api Documentation",
                "1",
                "就我自己还想要terms?",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()

        );


    }
}
