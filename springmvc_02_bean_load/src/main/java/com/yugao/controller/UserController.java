package com.yugao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    // 我们首先在运行配置中设置tomcat
    // 然后设置应用上下文地址为 "/"
    // 这时我们访问localhost:8080/save的时候 就会看到页面显示的我们下面方法的返回内容
    // 这里的ResponseBody注解的目的是直接将方法的返回值作为HTTP请求的响应体返回给客户端, 而不是解析成view(视图)
    // 如果这里不用ResponseBody注解的话 他会当成在根目录下的jsp文件名并寻找对应文件并返回 这就是默认为视图的定义
    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        System.out.println("save");
        return "{'info':'springmvc'}";
    }
}
