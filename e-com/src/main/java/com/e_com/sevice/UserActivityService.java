package com.e_com.sevice;

import com.e_com.rest_class.RestUserData;

public interface UserActivityService {

    public RestUserData updateUserWishlist(int wishlistId , int productId);

    public RestUserData addProductInUserCart(int cartId , int productId);

    public RestUserData deleteProductFromUserCart(int cartId , int productId);


}
