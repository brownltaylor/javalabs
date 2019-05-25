package com.brown.userinfo.controller;

import com.brown.userinfo.service.UserService;
import com.brown.userinfo.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(){

    }

    @RequestMapping(value="/users", method= RequestMethod.GET)
    public ResponseEntity<?>




}
