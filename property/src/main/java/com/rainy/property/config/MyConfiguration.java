package com.rainy.property.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @version v1.0
 * @ProjectName: property
 * @ClassName: MyConfiguration
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 34789
 * @Date: 2020/4/7 22:22
 */
@Configuration
public class MyConfiguration implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").exposedHeaders(HttpHeaders.SET_COOKIE).allowCredentials(true).maxAge(1800);

    }

    //    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
////                registry.addMapping("/login")
////                        .allowedOrigins("http://localhost:9527/")
////                        .allowedMethods("PUT", "DELETE","POST")
////                        .allowCredentials(false)
////                        .maxAge(3600);
////                registry.addMapping("/house").allowedOrigins("http://localhost:9527/");
//                registry.addMapping("/**")
//                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
//            }
//        };
//    }
}
