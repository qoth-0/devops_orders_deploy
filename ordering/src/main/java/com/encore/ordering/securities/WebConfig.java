package com.encore.ordering.securities;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://www.qoth-0.shop")
                .allowedMethods("*") // 모든 method
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}