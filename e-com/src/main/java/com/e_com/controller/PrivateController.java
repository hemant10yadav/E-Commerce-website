package com.e_com.controller;

import com.e_com.Entity.User;
import com.e_com.rest_class.RestUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.e_com.sevice.UserService;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/api/private")
public class PrivateController {

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
    @PostMapping("/user/{theUserId}/product/{theProductId}")
    public RestUserData updateUserCart(@PathVariable int theUserId, @PathVariable int theProductId) {
        return this.userService.updateUserCart(theUserId ,theProductId);
    }

    @PostMapping("/user/{userId}/wishlist/{productId}")
    public RestUserData updateWishlist(@PathVariable int userId , @PathVariable int productId){
        this.userService.updateUserWishlist(userId ,productId);
        return null;
    }

    @GetMapping("/user")
    public RestUserData currentUserName(Principal principal) {
        return this.userService.getUserByUsername(principal.getName());
    }
}
