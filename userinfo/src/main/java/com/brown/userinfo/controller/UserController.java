package com.brown.userinfo.controller;

import com.brown.userinfo.service.UserService;
import com.brown.userinfo.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

public class UserController {

    @Autowired
    private UserService userService;

    public UserController(){

    }

    @RequestMapping(value="/users", method= RequestMethod.GET)
    public ResponseEntity<?> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value="/users", method= RequestMethod.POST)
    public ResponseEntity<?> createUser(@Valid @RequestBody UserInfo user){
        return userService.saveUser(user);
    }

    @RequestMapping(value="/user/{userId}", method= RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return userService.delete(id);
    }

    @RequestMapping(value="/user/{userId}", method= RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserInfo user){
        return userService.update(user);
    }

    @RequestMapping(value="/users/{userId}", method=RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable Long id){
        return userService.getUser(id);
    }



}
