package com.test.config;


import com.test.filter.LoginInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyWebMvcConfig  implements WebMvcConfigurer {
    @Autowired
    LoginInte loginInte;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInte).addPathPatterns("/**");
    }
}
