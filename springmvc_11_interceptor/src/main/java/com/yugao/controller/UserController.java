package com.yugao.controller;

import com.yugao.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/{id}")
    public String save(@RequestBody User user, @PathVariable("id") int id, @RequestParam("name") String name) {
        System.out.println("user save..." + user + " id: " + id + " name: " + name);
        return "{'module':"
                + id + name + user + "}";
    }
}
