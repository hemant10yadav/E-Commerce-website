package com.e_com.Controller;

import com.e_com.Entity.Product;
import com.e_com.Sevice.ProductImageService;
import com.e_com.Sevice.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private ProductImageService theProductImageService;


    @PostMapping("/save")
    public void saveProduct(@RequestBody Product theProduct) {
        System.out.println("enter products===>>" + theProduct);
        this.productServiceImpl.saveProduct(theProduct);
    }

    @PostMapping("/image")
    public void saveImage(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Hello we entered into saveImage section");
        theProductImageService.saveImage(file);
    }

}
