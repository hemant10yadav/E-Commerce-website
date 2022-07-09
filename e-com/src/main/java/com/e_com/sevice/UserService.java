package com.e_com.sevice;

import java.util.List;

import com.e_com.Entity.User;
import com.e_com.rest_class.RestUser;
import com.e_com.rest_class.RestUserData;

public interface UserService {

    public List<User> getAllUsers();

    public User getUser(int theId);

    public void saveUser(RestUser theUser);

    public RestUserData getUserByUsername(String username);

    public RestUserData updateUserCart(int userId, int productId);
    public RestUserData updateUserWishlist(int userId, int productId);

}
