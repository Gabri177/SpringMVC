package com.yugao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/user/save")
    @ResponseBody
    public String save() {
        System.out.println("UserController save method was called ...");
        return "{'userController': 'save'}";
    }
}
