package com.yugao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//3.创建springMVC的配置文件, 加载controller对应的bean
@Configuration
@ComponentScan("com.yugao.controller")
public class SpringConfig {
}
