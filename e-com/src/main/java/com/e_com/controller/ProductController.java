package com.e_com.controller;
import com.e_com.rest_class.RestProduct;
import com.e_com.sevice.ProductService;
import com.e_com.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/public/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public void saveProduct(@RequestBody RestProduct restProduct) {
        this.productService.saveProduct(restProduct);
    }

    @GetMapping()
    public List<RestProduct> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public RestProduct getProductById(@PathVariable int id){
     return this.productService.getProduct(id);
    }
}
