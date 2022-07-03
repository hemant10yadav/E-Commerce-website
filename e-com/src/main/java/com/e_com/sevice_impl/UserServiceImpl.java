package com.e_com.sevice_impl;

import java.util.List;

import com.e_com.rest_class.RestUser;
import com.e_com.sevice.UserServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e_com.dao.UserDao;
import com.e_com.Entity.User;

@Service
public class UserServiceImpl implements UserServiceDao {

	@Autowired
	private UserDao userDao;

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public User getUser(int theId) {
		// TODO Auto-generated method stub
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

}
