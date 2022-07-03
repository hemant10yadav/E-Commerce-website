package com.e_com.controller;

import com.e_com.Entity.Product;
import com.e_com.Entity.ProductImage;
import com.e_com.rest_class.RestProduct;
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
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private UserServiceDao userServiceDao;


    @PostMapping()
    public void saveProduct(@RequestBody RestProduct restProduct) throws SQLException, UnsupportedEncodingException {
        //System.out.println(restProduct);

        Product theProduct = new Product();

        for (String s : restProduct.getImage()) {
            ProductImage theProductImage = new ProductImage();
            byte[] hem = s.getBytes(StandardCharsets.UTF_8);
            theProductImage.setImageData(hem);
            theProduct.addImage(theProductImage);
        }
        theProduct.setProductName(restProduct.getProductName());
        theProduct.setCategory(restProduct.getCategory());
        theProduct.setSubcategory(restProduct.getSubcategory());
        theProduct.setPrice(restProduct.getPrice());
        theProduct.setDescription(restProduct.getDescription());

        System.out.println("enter products===>>" + theProduct);
        this.productServiceImpl.saveProduct(theProduct);
    }

    @GetMapping()
    public ArrayList<RestProduct> getProducts() {
        List<Product> products =  this.productServiceImpl.getProducts();
        System.out.println("got the list of products " + products.size());
        ArrayList<RestProduct> restProducts =  new ArrayList<>();
        for(Product theProduct : products ) {
            RestProduct tempRestProduct = new RestProduct();
            ArrayList<String> imagesString = new ArrayList<>();
            List<ProductImage> productImage =  theProduct.getProductImage();
            for(ProductImage theProductImage : productImage ) {
                String str = new String(theProductImage.getImageData() , StandardCharsets.UTF_8);
                imagesString.add(str);
            }
            tempRestProduct.setProductName(theProduct.getProductName());
            tempRestProduct.setCategory(theProduct.getCategory());
            tempRestProduct.setSubcategory(theProduct.getSubcategory());
            tempRestProduct.setPrice(theProduct.getPrice());
            tempRestProduct.setDescription(theProduct.getDescription());
            tempRestProduct.setImage(imagesString);
            restProducts.add(tempRestProduct);
        }
        System.out.println(restProducts.size());
        return  restProducts;
    }
}
