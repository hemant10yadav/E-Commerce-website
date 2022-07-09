package com.e_com.rest_class;

import com.e_com.Entity.Cart;
import com.e_com.Entity.Wishlist;

import java.time.LocalDateTime;

public class RestUserData {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private LocalDateTime date;

    private Cart cart;

    private Wishlist wishlist;

    public RestUserData() {
    }

    public RestUserData(int id, String firstName, String lastName, String username,
                        String email, LocalDateTime date, Cart cart, Wishlist wishlist) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.date = date;
        this.cart = cart;
        this.wishlist = wishlist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }


}