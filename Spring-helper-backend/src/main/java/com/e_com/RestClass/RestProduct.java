package com.e_com.RestClass;

import java.util.ArrayList;

public class RestProduct {

    private String productName;
    private String category;
    private String subcategory;
    private int price;
    private ArrayList<String> image;

    public RestProduct() {
    }

    public RestProduct(String productName, String category, String subcategory, int price, ArrayList<String> image) {
        this.productName = productName;
        this.category = category;
        this.subcategory = subcategory;
        this.price = price;
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
                ", image=" + image +
                '}';
    }
}
