package com.example.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {


    WebConfig(){
        System.out.println("created  created created");
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5500", "http://127.0.0.1:5500") // todo : 프론트 서버 배포 후 변경
                .allowedHeaders("*")
                .allowedMethods("GET","PSOT")
                .maxAge(5000);
    }
}
