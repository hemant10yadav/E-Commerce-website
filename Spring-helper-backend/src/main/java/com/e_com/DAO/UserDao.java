package com.e_com.DAO;

import java.util.List;

import com.e_com.Entity.Users;

public interface UserDao {

	public List<Users> getAllUsers();
	public Users getUser(int theId);
	public Users saveUser(Users theUser);
}
