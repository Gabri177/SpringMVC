package com.yugao.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletContainerInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    //指定Spring配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //指定SpringMVC配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    //指定DispatcherServlet的映射规则
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
