package com.boots.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/news").setViewName("news");
        registry.addViewController("/event").setViewName("event");
        registry.addViewController("/creatLocation").setViewName("createLocation");
        registry.addViewController("/creatLocation/add_location").setViewName("add_location");
        registry.addViewController("/create_race").setViewName("create_race");

    }
}
