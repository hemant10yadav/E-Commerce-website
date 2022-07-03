package com.e_com.sevice;

import com.e_com.Entity.Product;

import java.util.List;

public interface ProductService {

    public void saveProduct(Product theProduct);

    public Product getProduct(int Id);

    public List<Product> getProducts();
}
