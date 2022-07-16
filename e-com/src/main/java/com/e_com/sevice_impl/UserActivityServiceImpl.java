package com.e_com.sevice_impl;

import com.e_com.Entity.*;
import com.e_com.dao.UserDao;
import com.e_com.rest_class.RestUserData;
import com.e_com.sevice.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserActivityServiceImpl implements UserActivityService {

    @Autowired
    private UserDao userDao;

    @Override
    public RestUserData updateUserWishlist(int userId, int productId) {

        //get user from db
        User user = this.userDao.getUser(userId);
        Wishlist wishlist = user.getWishlist();

        // created a new wishlistProduct and updated wishlistId and productId in it
        WishlistProduct wishlistProduct = new WishlistProduct();
        wishlistProduct.setWishlistId(wishlist.getId());
        wishlistProduct.setProductId(productId);

        // initialise list of wishlistProducts to add old and new wishlist product
        List<WishlistProduct> tempWishlistProduct;

        //check if wishlistProduct is null or not if null then create new list
        if (wishlist.getWishlistProduct() == null) {
            tempWishlistProduct = new ArrayList<>();
        } else tempWishlistProduct = wishlist.getWishlistProduct();

        //check if productId is already present in wishlist product if it is then delete it
        if (tempWishlistProduct.stream().anyMatch((wishlistProduct1 -> wishlistProduct1.getProductId() == productId))) {
            tempWishlistProduct.removeIf(wishlistProduct1 -> wishlistProduct1.getProductId() == productId);
        } else tempWishlistProduct.add(wishlistProduct);
        wishlist.setWishlistProduct(tempWishlistProduct);

        //set wishlist in user
        user.setWishlist(wishlist);

        // save updated user details
        this.userDao.saveUser(user);
        user = this.userDao.getUser(userId);
        return new RestUserData(user.getId(), user.getFirstName(), user.getLastName(),
                user.getUsername(), user.getEmail(), user.getDate(),
                user.getCart(), user.getWishlist());
    }


    @Override
    public RestUserData addProductInUserCart(int userId, int productId, boolean deleteAction) {

        //get user from db
        User user = this.userDao.getUser(userId);
        Cart cart = cart = user.getCart();

        // created a new cartProduct and updated CartId and productId in it
        CartProducts cartProduct = new CartProducts();
        cartProduct.setCartId(cart.getId());
        cartProduct.setProductId(productId);

        // initialise list of CartProducts to add old and new CartProducts
        List<CartProducts> tempCartProducts;

        //check if CartProducts is null or no if null then create new list
        if (cart.getCartProducts() == null) {
            tempCartProducts = new ArrayList<>();
        } else tempCartProducts = cart.getCartProducts();

        //check if deleteAction is true if true delete product id else add new cartProductId to list of cartProduct
        if (deleteAction) {
            for (CartProducts temp : tempCartProducts) {
                if (temp.getProductId() == productId) {
                    tempCartProducts.remove(temp);
                    break;
                }
            }
        } else tempCartProducts.add(cartProduct);

        //set list into carts
        cart.setCartProducts(tempCartProducts);
        user.setCart(cart);
        this.userDao.saveUser(user);
        user = this.userDao.getUser(userId);
        return new RestUserData(user.getId(), user.getFirstName(), user.getLastName(),
                user.getUsername(), user.getEmail(), user.getDate(),
                user.getCart(), user.getWishlist());
    }

}
