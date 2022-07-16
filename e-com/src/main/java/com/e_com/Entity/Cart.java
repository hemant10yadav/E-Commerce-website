package com.e_com.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cartId", orphanRemoval = true)
    private List<CartProducts> cartProducts;

    public Cart() {
    }

    public Cart(int id, List<CartProducts> cartProducts) {
        this.id = id;
        this.cartProducts = cartProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CartProducts> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProducts> cartProducts) {
        this.cartProducts = cartProducts;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartProducts=" + cartProducts +
                '}';
    }
}
