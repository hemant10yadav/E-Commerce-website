package com.e_com.sevice_impl;

import java.util.List;

import com.e_com.Entity.*;
import com.e_com.rest_class.RestUser;
import com.e_com.rest_class.RestUserData;
import com.e_com.sevice.UserService;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e_com.dao.UserDao;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public UserServiceImpl() {
    }

    @Override
    public List<User> getAllUsers() {
        return Collections.emptyList();
    }

    @Override
    public User getUser(int theId) {
        return userDao.getUser(theId);
    }

    @Override
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
    public RestUserData getRestUserByUsername(String username) {
        User theUser = this.userDao.getUserByUsername(username);
        return new RestUserData(theUser.getId(), theUser.getFirstName(),
                theUser.getLastName(), theUser.getUsername(), theUser.getEmail(),
                theUser.getDate(), theUser.getCart(), theUser.getWishlist());
    }
    @Override
    public User getUserByUsername(String username) {
        return this.userDao.getUserByUsername(username);
    }

    @Override
    public boolean isUsernamePresent(String username) {
        return this.userDao.isUsernamePresent(username);
    }

    @Override
    public boolean isEmailPresent(String email) {
        return this.userDao.isEmailPresent(email);
    }


}
