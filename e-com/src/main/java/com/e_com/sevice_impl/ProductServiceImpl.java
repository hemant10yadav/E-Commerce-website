package com.e_com.sevice_impl;

import com.e_com.Entity.ProductImage;
import com.e_com.dao.ProductDao;
import com.e_com.Entity.Product;
import com.e_com.rest_class.RestProduct;
import com.e_com.sevice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductDao productDao;


    @Override
    public void saveProduct(RestProduct restProduct) {
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
        productDao.saveProduct(theProduct);
    }

    @Override
    public RestProduct getProduct(int id) {
        Product theProduct = productDao.getProduct(id);

        //converting blob into string
        ArrayList<String> imagesString = new ArrayList<>();
        List<ProductImage> productImage = theProduct.getProductImage();
        for (ProductImage theProductImage : productImage) {
            String str = new String(theProductImage.getImageData(), StandardCharsets.UTF_8);
            imagesString.add(str);
        }
        return new RestProduct(theProduct.getId(), theProduct.getProductName(),
                theProduct.getCategory(), theProduct.getSubcategory(),
                theProduct.getPrice(), theProduct.getDescription(),
                imagesString);
    }

    @Override
    public List<RestProduct> getProducts() {
        List<Product> products = this.productDao.getProducts();
        ArrayList<RestProduct> restProducts = new ArrayList<>();
        for (Product theProduct : products) {
            RestProduct tempRestProduct = new RestProduct();

            // Converting image blob into string
            ArrayList<String> imagesString = new ArrayList<>();
            List<ProductImage> productImage = theProduct.getProductImage();
            for (ProductImage theProductImage : productImage) {
                String str = new String(theProductImage.getImageData(), StandardCharsets.UTF_8);
                imagesString.add(str);
            }
            tempRestProduct.setId(theProduct.getId());
            tempRestProduct.setProductName(theProduct.getProductName());
            tempRestProduct.setCategory(theProduct.getCategory());
            tempRestProduct.setSubcategory(theProduct.getSubcategory());
            tempRestProduct.setPrice(theProduct.getPrice());
            tempRestProduct.setDescription(theProduct.getDescription());
            tempRestProduct.setImage(imagesString);
            restProducts.add(tempRestProduct);
        }
        return restProducts;
    }
}
