package com.e_com.sevice;

import com.e_com.Entity.Product;
import com.e_com.rest_class.RestProduct;

import java.util.List;

public interface ProductService {

    public void saveProduct(RestProduct theProduct);

    public RestProduct getProduct(int id);

    public List<RestProduct> getProducts();
}
