package com.e_com.sevice_impl;

import java.util.List;

import com.e_com.repository.UserRepoImpl;
import com.e_com.repository.UserRepository;
import com.e_com.rest_class.RestUser;
import com.e_com.rest_class.RestUserData;
import com.e_com.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e_com.dao.UserDao;
import com.e_com.Entity.User;

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
        userDao.saveUser(dbUser);
    }

    @Override
    @Transactional
    public RestUserData getUserByUsername(String username) {
        User theUser = this.userRepository.findByUserName(username);
        return new RestUserData(theUser.getFirstName(),
                theUser.getLastName(), theUser.getUsername(), theUser.getEmail(),
                theUser.getDate());
    }

}
