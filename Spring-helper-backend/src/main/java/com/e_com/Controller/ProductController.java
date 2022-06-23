package com.e_com.Controller;

import com.e_com.Entity.Product;
import com.e_com.Entity.ProductImage;
import com.e_com.RestClass.RestProduct;
import com.e_com.Sevice.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/save")
    public void saveProduct(@RequestBody RestProduct restProduct) {


        ProductImage theProductImage = new ProductImage();
        theProductImage.setImageData(restProduct.getImage());

        Product theProduct = new Product();
        theProduct.setProductName(restProduct.getProductName());
        theProduct.setCategory(restProduct.getCategory());
        theProduct.setSubcategory(restProduct.getSubcategory());
        theProduct.setPrice(restProduct.getPrice());
        theProduct.setProductImage(theProductImage);

        System.out.println("enter products===>>" + theProduct);

        this.productServiceImpl.saveProduct(theProduct);
    }

}
