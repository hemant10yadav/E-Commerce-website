package com.e_com.Sevice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.e_com.Entity.Users;

public interface UserServiceDao {

	public List<Users> getAllUsers();
	public Users getUser(int theId);
	public Users saveUser(Users theUser);
	
}
