package com.e_com.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;

@Entity
@Table(name = "product_images")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="image_data")
    private byte[] imageData;

    public ProductImage() {
    }

    public ProductImage(int id, byte[] imageData) {
        this.id = id;
        this.imageData = imageData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", imageData='" + Arrays.toString(imageData) + '\'' +
                '}';
    }
}
