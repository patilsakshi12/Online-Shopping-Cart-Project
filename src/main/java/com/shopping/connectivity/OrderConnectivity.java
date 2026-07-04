package com.shopping.connectivity;

import java.util.List;

import com.shopping.model.Orders;

public interface OrderConnectivity {
public int placeOrderBy(int userId, double total,String payment,String address,String phone);
public boolean clearCart(int userId);
public List<Orders> getAllOrders();
public List<Orders> getMyOrders( int userId);
public boolean cancelOrder(int orderId);
public int placeBuyNowOrder(int userId, int productId, double total, String payment, String address, String phone);
public boolean updateStatus(int orderId, String status);



}
