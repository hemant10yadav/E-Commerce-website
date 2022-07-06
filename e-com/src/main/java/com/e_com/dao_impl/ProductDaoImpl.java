package com.e_com.dao_impl;

import com.e_com.dao.ProductDao;
import com.e_com.Entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveProduct(Product theProduct) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theProduct);
    }

    @Override
    public Product getProduct(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Product.class,id);
    }

    @Override
    public List<Product> getProducts() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Product", Product.class).list();
    }
}
