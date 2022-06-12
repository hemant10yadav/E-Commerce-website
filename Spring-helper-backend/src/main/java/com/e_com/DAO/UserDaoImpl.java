package com.e_com.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.e_com.Entity.Users;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
	public UserDaoImpl() {
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
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theUser);
		return null;
	}

}
