package com.e_com.sevice;

import java.util.List;

import com.e_com.Entity.User;

public interface UserServiceDao {

    public List<User> getAllUsers();

    public User getUser(int theId);

    public User saveUser(User theUser);

}
