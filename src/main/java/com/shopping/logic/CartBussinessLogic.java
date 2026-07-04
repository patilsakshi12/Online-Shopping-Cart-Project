package com.shopping.logic;

import com.shopping.model.Cart;
import com.shopping.model.CartItem;

import java.util.ArrayList;
import java.util.List;

import com.shopping.connectivity.*;
import com.shopping.database.CartDatabase;
public class CartBussinessLogic {
	
	// add to cart
public boolean addToCart(Cart cart) {
	
	if(cart.getQuantity()<=0) {
		 cart.setQuantity(1); // default quantity
		
	}
	CartConnectivity ref=new CartDatabase();
	return ref.addCart(cart);
}

// view cart
public List<CartItem> viewCart(int userId) {

    CartConnectivity ref = new CartDatabase();
    return ref.getCartItmes(userId);
}

//remove cart
public boolean removeItem(int cardId) {
	CartConnectivity ref= new CartDatabase();
	return ref.removeCartItem(cardId);
}
public boolean clearCart(int userId) {
    CartConnectivity ref = new CartDatabase();
    return ref.clearCart(userId);
}
//increase
public boolean increaseQuantity(int cartId){

    CartConnectivity db = new CartDatabase();

    return db.increaseQuantity(cartId);

}

public boolean decreaseQuantity(int cartId){

    CartConnectivity db =new CartDatabase();

    return db.decreaseQuantity(cartId);

}
}

