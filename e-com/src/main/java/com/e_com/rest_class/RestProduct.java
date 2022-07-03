package com.e_com.rest_class;

import java.util.ArrayList;

public class RestProduct {

    private String productName;
    private String category;
    private String subcategory;
    private int price;

    private String description;
    private ArrayList<String> image;

    public RestProduct() {
    }

    public RestProduct(String productName, String category, String subcategory, int price, String description, ArrayList<String> image) {
        this.productName = productName;
        this.category = category;
        this.subcategory = subcategory;
        this.price = price;
        this.description = description;
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getImage() {
        return image;
    }

    public void setImage(ArrayList<String> image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "RestProduct{" +
                "productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image=" + image +
                '}';
    }
}
