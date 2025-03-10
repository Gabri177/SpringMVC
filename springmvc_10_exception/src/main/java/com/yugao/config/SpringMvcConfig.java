package com.yugao.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.yugao.controller"})
@EnableWebMvc
public class SpringMvcConfig {

}
