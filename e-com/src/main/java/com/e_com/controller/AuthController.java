package com.e_com.controller;

import com.e_com.Entity.User;
import com.e_com.rest_class.RestUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.e_com.sevice.UserService;

import java.security.Principal;

/**
 * @author Hemant Singh Yadav
 */
@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/user/{theId}")
    public User getUser(@PathVariable int theId) {
        return this.userService.getUser(theId);
    }

    @GetMapping("/user")
    public RestUserData currentUserName(Principal principal) {
        return this.userService.getRestUserByUsername(principal.getName());
    }
}
