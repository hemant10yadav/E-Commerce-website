package com.e_com.Entity;

import javax.persistence.*;

@Entity
@Table(name = "cart_products")
public class CartProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "cart_id")
    private int cartId;

    public CartProducts() {
    }

    public CartProducts(int id, int productId, int cartId) {
        this.id = id;
        this.productId = productId;
        this.cartId = cartId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "CartProductsI{" +
                "id=" + id +
                ", productId=" + productId +
                ", cartId=" + cartId +
                '}';
    }
}
