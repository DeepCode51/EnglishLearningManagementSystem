package com.chun.myspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
    public class MyMvcConfig implements WebMvcConfigurer {
    //跳转页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/user/login.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/register.html").setViewName("user/register/page-register");
    }

    //拦截所有，放行部分路径
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/login","/css/**",
                "/js/**","/images/**","","/register.html","/register","/user/checkCode","/toAdmin","/admin","/lib/**");
    }

}
