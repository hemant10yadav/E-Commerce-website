package com.e_com.Entity;

import javax.persistence.*;

@Entity
@Table(name = "wishlist_products")
public class WishlistProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "wishlist_id")
    private int wishlistId;

    @Column(name = "product_id")
    private int productId;

    public WishlistProduct() {
    }

    public WishlistProduct(int id, int wishlistId, int productId) {
        this.id = id;
        this.wishlistId = wishlistId;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "WishlistProduct{" +
                "id=" + id +
                ", wishlistId=" + wishlistId +
                ", productId=" + productId +
                '}';
    }
}
