package com.e_com.controller;

import com.e_com.Entity.Product;
import com.e_com.Entity.ProductImage;
import com.e_com.rest_class.RestProduct;
import com.e_com.sevice.ProductService;
import com.e_com.sevice_impl.ProductServiceImpl;
import com.e_com.sevice.UserServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserServiceDao userServiceDao;


    @PostMapping()
    public void saveProduct(@RequestBody RestProduct restProduct) {
        this.productService.saveProduct(restProduct);
    }

    @GetMapping()
    public List<RestProduct> getProducts() {
        return (ArrayList<RestProduct>) productService.getProducts();
    }
}
