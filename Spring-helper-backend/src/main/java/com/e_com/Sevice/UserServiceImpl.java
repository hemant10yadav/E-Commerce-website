package com.e_com.Sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e_com.DAO.UserDao;
import com.e_com.Entity.Users;

@Service
public class UserServiceImpl implements UserServiceDao {

	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Users getUser(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Users saveUser(Users theUser) {
		return userDao.saveUser(theUser);
	}

}
