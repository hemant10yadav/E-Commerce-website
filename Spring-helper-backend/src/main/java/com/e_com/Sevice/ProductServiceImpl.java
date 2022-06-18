package com.e_com.Sevice;

import com.e_com.DAO.ProductDao;
import com.e_com.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductDao productDao;


    @Override
    public void saveProduct(Product theProduct) {
        productDao.saveProduct(theProduct);
    }

    @Override
    public Product getProduct(int Id) {
        return productDao.getProduct(Id);
    }

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }
}
