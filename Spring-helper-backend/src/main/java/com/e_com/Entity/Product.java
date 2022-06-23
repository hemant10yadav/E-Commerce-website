package com.e_com.Entity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "category")
    private String category;

    @Column(name = "subcategory")
    private String subcategory;

    @Column(name = "price")
    private int price;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<ProductImage> productImage;

    public Product() {
    }

    public Product(int id, String productName, String category, String subcategory, int price, List<ProductImage> productImage) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.subcategory = subcategory;
        this.price = price;
        this.productImage = productImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<ProductImage> getProductImage() {
        return productImage;
    }

    public void setProductImage(List<ProductImage> productImage) {
        this.productImage = productImage;
    }

    public void addImage(ProductImage theProductImage) {
        if (productImage == null) {
            productImage = new ArrayList<>();
        }
        productImage.add(theProductImage);

    }
}
