package com.e_com.dao_impl;

import java.util.List;

import com.e_com.dao.UserDao;

import java.util.Collections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.e_com.Entity.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<User> getAllUsers() {
        return Collections.emptyList();
    }

    @Override
    public User getUser(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(User.class, theId);
    }

    @Override
    public void saveUser(User theUser) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theUser);
    }

    @Override
    public void getUserByUsername(String username) {
        System.out.println("==========================");
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from User where username =:username ")
                .setParameter("username ", username);
        System.out.println(query);
        System.out.println(query.getFirstResult());
    }

}
