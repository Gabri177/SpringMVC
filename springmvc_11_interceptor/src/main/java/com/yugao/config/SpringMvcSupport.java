package com.yugao.config;

import com.yugao.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {

    // 为了简化 我们可以直接不用写这个文件 将下面的内容写到SpringMvcConfig中
    // 注意在SpringMvcConfig中需要继承WebMvcConfigurer
//    @Autowired
//    private ProjectInterceptor projectInterceptor;
//
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(projectInterceptor).addPathPatterns("/**");
//    }
//
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
//    }
}
