package com.iamjesus.homework.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // "/**"는 모든 경로에 대해 CORS 설정을 적용한다는 의미입니다.
                .allowedOrigins("*") // 자바스크립트 요청을 허용할 출처를 명시합니다. (Live Server 기본값)
                .allowedMethods("*") // 허용할 HTTP 메서드를 설정합니다.
                .allowedHeaders("*"); // 허용할 요청 헤더를 설정합니다. ("*"는 모든 헤더를 허용)
    }
}