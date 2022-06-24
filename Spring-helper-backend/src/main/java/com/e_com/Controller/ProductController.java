package com.e_com.Controller;

import com.e_com.Entity.Product;
import com.e_com.Entity.ProductImage;
import com.e_com.RestClass.RestProduct;
import com.e_com.Sevice.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Iterator;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;


    @PostMapping("/save")
    public void saveProduct(@RequestBody RestProduct restProduct) throws SQLException, UnsupportedEncodingException {
        //System.out.println(restProduct);

        Product theProduct = new Product();

        Iterator<String> iterate = restProduct.getImage().iterator();
        while (iterate.hasNext()){
            ProductImage theProductImage = new ProductImage();
            byte[] hem = iterate.next().getBytes(StandardCharsets.UTF_8);
            theProductImage.setImageData(hem);
            theProduct.addImage(theProductImage);
        }
        theProduct.setProductName(restProduct.getProductName());
        theProduct.setCategory(restProduct.getCategory());
        theProduct.setSubcategory(restProduct.getSubcategory());
        theProduct.setPrice(restProduct.getPrice());

        System.out.println("enter products===>>" + theProduct);
        this.productServiceImpl.saveProduct(theProduct);
    }

}
