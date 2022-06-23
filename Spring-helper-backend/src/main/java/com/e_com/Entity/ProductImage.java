package com.e_com.Entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "product_images")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="image_data")
    private String imageData;

    public ProductImage() {
    }

    public ProductImage(int id, String imageData) {
        this.id = id;
        this.imageData = imageData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", imageData='" + imageData + '\'' +
                '}';
    }
}
