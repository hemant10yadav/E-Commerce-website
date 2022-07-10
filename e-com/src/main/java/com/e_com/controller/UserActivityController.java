package com.e_com.controller;

import com.e_com.rest_class.RestUserData;
import com.e_com.sevice.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserActivityController {

    @Autowired
    private UserActivityService userActivityService;


    @PostMapping("/{userId}/cart/{productId}")
    public RestUserData updateUserCart(@PathVariable int userId, @PathVariable int productId) {
        return this.userActivityService.addProductInUserCart(userId, productId);
    }

    @PostMapping("/{userId}/wishlist/{productId}")
    public RestUserData updateWishlist(@PathVariable int userId, @PathVariable int productId) {
        return this.userActivityService.updateUserWishlist(userId, productId);
    }
}
