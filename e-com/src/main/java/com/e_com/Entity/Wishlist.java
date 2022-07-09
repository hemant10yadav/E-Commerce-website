package com.e_com.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wishlists")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wishlistId")
    private List<WishlistProduct> wishlistProduct;

    public Wishlist() {
    }

    public Wishlist(int id, List<WishlistProduct> wishlistProduct) {
        this.id = id;
        this.wishlistProduct = wishlistProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<WishlistProduct> getWishlistProduct() {
        return wishlistProduct;
    }

    public void setWishlistProduct(List<WishlistProduct> wishlistProduct) {
        this.wishlistProduct = wishlistProduct;
    }
}
