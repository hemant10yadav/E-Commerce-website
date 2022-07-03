package com.e_com.dao;

import com.e_com.Entity.Product;

import java.util.List;

public interface ProductDao {

    public void saveProduct(Product theProduct);

    public Product getProduct(int id);

    public List<Product> getProducts();

}
