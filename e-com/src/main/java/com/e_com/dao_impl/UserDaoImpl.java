package com.e_com.dao_impl;

import java.util.List;

import com.e_com.dao.UserDao;

import java.util.Collections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.e_com.Entity.User;

/**
 * @author Hemant Singh Yadav
 */
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
        currentSession.save(theUser);
    }

    @Override
    public User getUserByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
       return currentSession.
               createQuery("from User u where u.username=:username",User.class)
               .setParameter("username", username)
               .uniqueResult();

    }


    @Override
    public User updateUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(user);
        return currentSession.get(User.class, user.getId());
    }


    @Override
    public boolean isUsernamePresent(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        User result = currentSession.
                createQuery("from User u where u.username=:username",User.class)
                .setParameter("username", username)
                .uniqueResult();
        return result != null;
    }

    @Override
    public boolean isEmailPresent(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        User result = currentSession.createQuery("from User where u.email=:email",User.class)
                        .setParameter("email",email).uniqueResult();
        return result != null;
    }

}
