package com.javamentor.qa.platform.webapp.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/questions/ask").setViewName("question");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/questions").setViewName("questions");
        registry.addViewController("/tour").setViewName("tour");
        registry.addViewController("/tag_page").setViewName("tag_page");

    }
}
