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
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl() {
    }

    @Override
    public List<User> getAllUsers() {
        return null;
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
    public RestUserData getUserByUsername(String username) {
        User theUser = this.userRepository.findByUserName(username);
        return new RestUserData(theUser.getId(), theUser.getFirstName(),
                theUser.getLastName(), theUser.getUsername(), theUser.getEmail(),
                theUser.getDate(), theUser.getCart(), theUser.getWishlist());
    }


}
