package com.e_com.sevice_impl;

import java.util.ArrayList;
import java.util.List;

import com.e_com.Entity.*;
import com.e_com.repository.UserRepository;
import com.e_com.rest_class.RestUser;
import com.e_com.rest_class.RestUserData;
import com.e_com.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e_com.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl() {
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    @Transactional
    public User getUser(int theId) {
        return userDao.getUser(theId);
    }

    @Override
    @Transactional
    public void saveUser(RestUser theUser) {
        User dbUser = new User();
        dbUser.setFirstName(theUser.getFirstName());
        dbUser.setLastName(theUser.getLastName());
        dbUser.setPassword(theUser.getPassword());
        dbUser.setEmail(theUser.getEmail());
        dbUser.setUsername(theUser.getUsername());
        Cart cart = new Cart();
        dbUser.setCart(cart);
        Wishlist wishlist = new Wishlist();
        dbUser.setWishlist(wishlist);
        userDao.saveUser(dbUser);
    }

    @Override
    @Transactional
    public RestUserData getUserByUsername(String username) {
        User theUser = this.userRepository.findByUserName(username);
        return new RestUserData(theUser.getId(), theUser.getFirstName(),
                theUser.getLastName(), theUser.getUsername(), theUser.getEmail(),
                theUser.getDate(), theUser.getCart(), theUser.getWishlist());
    }

    @Override
    @Transactional
    public RestUserData updateUserCart(int userId, int productId) {
        User user = this.userDao.getUser(userId);
        Cart cart;
        List<CartProducts> tempCartProducts;
        if (user.getCart() == null) {
            cart = new Cart();
        } else cart = user.getCart();
        CartProducts cartProduct = new CartProducts();
        cartProduct.setCartId(cart.getId());
        cartProduct.setProductId(productId);
        if (cart.getCartProducts() == null) {
            tempCartProducts = new ArrayList<>();
        } else tempCartProducts = cart.getCartProducts();
        tempCartProducts.add(cartProduct);
        cart.setCartProducts(tempCartProducts);
        user.setCart(cart);
        this.userDao.saveUser(user);
        user = this.userDao.getUser(userId);
        return new RestUserData(user.getId(), user.getFirstName(), user.getLastName(),
                user.getUsername(), user.getEmail(), user.getDate(), user.getCart(), user.getWishlist());
    }

    @Override
    @Transactional
    public RestUserData updateUserWishlist(int userId, int productId) {
        User user = this.userDao.getUser(userId);
        List<WishlistProduct> tempWishlistProduct;
        Wishlist wishlist = user.getWishlist();
        WishlistProduct wishlistProduct = new WishlistProduct();
        wishlistProduct.setWishlistId(wishlist.getId());
        wishlistProduct.setProductId(productId);
        if (wishlist.getWishlistProduct() == null) {
            tempWishlistProduct = new ArrayList<>();
        } else tempWishlistProduct = wishlist.getWishlistProduct();
        tempWishlistProduct.add(wishlistProduct);
        wishlist.setWishlistProduct(tempWishlistProduct);
        user.setWishlist(wishlist);
        this.userDao.saveUser(user);
        return new RestUserData(user.getId(), user.getFirstName(), user.getLastName(),
                user.getUsername(), user.getEmail(), user.getDate(), user.getCart(), user.getWishlist());
    }
}
