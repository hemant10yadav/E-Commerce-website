package com.e_com.DAO;

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
        System.out.println("Enter into our repo========>>>  " + theProduct);
        currentSession.save(theProduct);
    }

    @Override
    public Product getProduct(int Id) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }
}
