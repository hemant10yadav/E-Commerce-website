package com.e_com.Sevice;

import java.util.List;

import com.e_com.DAO.UserDao;
import com.e_com.Entity.Users;

public class UserServiceImpl implements UserServiceDao {

	private UserDao userDao;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getUser(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users saveUser(Users theUser) {
		return userDao.saveUser(theUser);
	}

}
