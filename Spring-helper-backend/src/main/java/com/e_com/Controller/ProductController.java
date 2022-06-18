package com.e_com.Controller;

import com.e_com.Entity.Product;
import com.e_com.Sevice.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;


    @PostMapping("/save")
    public void saveProduct(@RequestBody Product theProduct) {
        System.out.println("enter products===>>" + theProduct);
        this.productServiceImpl.saveProduct(theProduct);
    }

}
