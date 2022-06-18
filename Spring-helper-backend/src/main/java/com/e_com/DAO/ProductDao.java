package com.e_com.DAO;

import com.e_com.Entity.Product;

import java.util.List;

public interface ProductDao {

    public void saveProduct(Product theProduct);

    public Product getProduct(int Id);

    public List<Product> getProducts();

}
