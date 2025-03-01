package com.yugao.config;

import com.yugao.controller.interceptor.ProjectInterceptor;
import com.yugao.controller.interceptor.ProjectInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@ComponentScan({"com.yugao.controller", "com.yugao.config"})
@ComponentScan("com.yugao.controller")
@EnableWebMvc
// 这样配置interceptor侵入性太强，不推荐
public class SpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Autowired
    private ProjectInterceptor2 projectInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器按照顺序执行 这就是拦截器链
        // 类似队列一样 先进先出
        // 拦截器的执行顺序是按照addInterceptor的顺序来的
        // 拦截器返回false 未执行的所有PostHandler不会执行 会跳转到上一个拦截器的afterCompletion方法...
        registry.addInterceptor(projectInterceptor).addPathPatterns("/**");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/**");
    }

}
