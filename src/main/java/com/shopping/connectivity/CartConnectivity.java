package com.shopping.connectivity;

import java.util.List;
import com.shopping.model.Cart;
import com.shopping.model.CartItem;

public interface CartConnectivity {
public boolean addCart(Cart cart);
public List<CartItem> getCartItmes(int userId);
public boolean removeCartItem(int cardId);
public boolean clearCart(int userId);
public boolean increaseQuantity(int cardId);
public boolean decreaseQuantity(int cardId);
}
