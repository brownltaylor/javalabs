package com.brown.userinfo.controller;

import com.brown.userinfo.service.UserService;
import com.brown.userinfo.domain.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Controller {

    private UserService userService;

    public Controller(UserService userservice){
        this.userService = userService;
    }

    @GetMapping("/list")
    public Iterable<UserInfo> list(){
        return userService.list();
    }


}
