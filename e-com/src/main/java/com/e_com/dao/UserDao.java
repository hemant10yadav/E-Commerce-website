package com.e_com.dao;

import java.util.List;

import com.e_com.Entity.User;

public interface UserDao {

	public List<User> getAllUsers();
	public User getUser(int theId);
	public void saveUser(User theUser);

	public void getUserByUsername(String username);


	public User updateUser(User user);
}
