package com.shopping.logic;

import java.util.List;

import com.shopping.connectivity.OrderConnectivity;
import com.shopping.database.OrderDatabase;
import com.shopping.model.Orders;

public class OrderBussinessLogic {

    public int placeOrder(int userId,
                          double total,
                          String payment,
                          String address,
                          String phone) {

        OrderConnectivity ref = new OrderDatabase();

        if (total <= 0 || payment == null) {
            return 0;
        }

        // ONLY PLACE ORDER
        int orderId = ref.placeOrderBy(userId, total, payment, address, phone);

        // DO NOT CLEAR CART HERE
        return orderId;
    }
    
    public int placeBuyNowOrder(int userId,
                                int productId,
                                double total,
                                String payment,
                                String address,
                                String phone) {

        OrderConnectivity ref = new OrderDatabase();

        if(total <= 0 || payment == null){
            return 0;
        }

        return ref.placeBuyNowOrder(
                userId,
                productId,
                total,
                payment,
                address,
                phone);
    }
   

	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub

        OrderConnectivity ref = new OrderDatabase();
        
		return ref.getAllOrders();
	}

	public List<Orders> getMyOrders(int userId){
		 OrderConnectivity ref = new OrderDatabase();
	        
			return ref.getMyOrders(userId);
		
	}

	public boolean cancelOrder(int orderId) {
		// TODO Auto-generated method stub
		 OrderConnectivity ref = new OrderDatabase();
		return ref.cancelOrder(orderId);
	}
	public boolean updateStatus(int orderId,String status){

		OrderConnectivity ref=
		new OrderDatabase();

		return ref.updateStatus(orderId,status);

		}
}