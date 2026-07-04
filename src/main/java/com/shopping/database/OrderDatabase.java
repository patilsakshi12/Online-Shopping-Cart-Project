package com.shopping.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.connectivity.OrderConnectivity;
import com.shopping.model.CartItem;
import com.shopping.model.Orders;

public class OrderDatabase implements OrderConnectivity {

    @Override
    public int placeOrderBy(int userId, double total,
                            String payment,
                            String address,
                            String phone) {

        List<CartItem> itemList = new ArrayList<>();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shopping",
                    "root",
                    "Shubham@1132");

            // 1. INSERT ORDER
            String sql =
                    "INSERT INTO orders(user_id,total_amount,payment_method,address,phone,status) " +
                    "VALUES (?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(
                    sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, userId);
            ps.setDouble(2, total);
            ps.setString(3, payment);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.setString(6, "PENDING");

            int rows = ps.executeUpdate();

            if (rows > 0) {

                // 2. GET ORDER ID
                ResultSet rs = ps.getGeneratedKeys();

                int orderId = 0;

                if (rs.next()) {
                    orderId = rs.getInt(1);
                }

                // 3. FETCH CART ITEMS
                String cartSql =
                        "SELECT c.product_id, c.quantity, p.price " +
                        "FROM cart c " +
                        "JOIN products p ON c.product_id = p.product_id " +
                        "WHERE c.user_id=?";

                PreparedStatement cps = con.prepareStatement(cartSql);
                cps.setInt(1, userId);

                ResultSet cartRs = cps.executeQuery();

                // 4. INSERT INTO ORDER_ITEMS
                String itemSql =
                        "INSERT INTO order_items(order_id,product_id,quantity,price) " +
                        "VALUES(?,?,?,?)";

                PreparedStatement ips = con.prepareStatement(itemSql);

                while (cartRs.next()) {

                    int productId = cartRs.getInt("product_id");
                    int qty = cartRs.getInt("quantity");
                    double price = cartRs.getDouble("price");

                    // insert into order_items table
                    ips.setInt(1, orderId);
                    ips.setInt(2, productId);
                    ips.setInt(3, qty);
                    ips.setDouble(4, price);

                    ips.executeUpdate();

                    // ADD TO LIST FOR JSP
                    CartItem item = new CartItem();
                    item.setProductId(productId);
                    item.setQuantity(qty);
                    item.setPrice(price);

                    itemList.add(item);
                }

               

                return orderId;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    
    
    //buynow
    @Override
    public int placeBuyNowOrder(int userId,
                                int productId,
                                double total,
                                String payment,
                                String address,
                                String phone) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
            DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shopping",
                    "root",
                    "Shubham@1132");

            // INSERT ORDER
            String sql =
            "INSERT INTO orders(user_id,total_amount,payment_method,address,phone,status) "
            + "VALUES(?,?,?,?,?,?)";

            PreparedStatement ps =
            con.prepareStatement(
                    sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, userId);
            ps.setDouble(2, total);
            ps.setString(3, payment);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.setString(6, "SUCCESS");

            int rows = ps.executeUpdate();

            if(rows > 0){

                ResultSet rs =
                ps.getGeneratedKeys();

                int orderId = 0;

                if(rs.next()){
                    orderId = rs.getInt(1);
                }

                // PRODUCT PRICE FETCH
                String productSql =
                "SELECT price FROM products WHERE product_id=?";

                PreparedStatement pps =
                con.prepareStatement(productSql);

                pps.setInt(1, productId);

                ResultSet prs =
                pps.executeQuery();

                double price = 0;

                if(prs.next()){
                    price = prs.getDouble("price");
                }

                // INSERT INTO ORDER_ITEMS
                String itemSql =
                "INSERT INTO order_items(order_id,product_id,quantity,price) "
                + "VALUES(?,?,?,?)";

                PreparedStatement ips =
                con.prepareStatement(itemSql);

                ips.setInt(1, orderId);
                ips.setInt(2, productId);
                ips.setInt(3, 1);
                ips.setDouble(4, price);

                ips.executeUpdate();

                con.close();

                return orderId;
            }
            
            

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return 0;
    }
    


    // CLEAR CART
    @Override
    public boolean clearCart(int userId) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shopping",
                    "root",
                    "Shubham@1132");

            String sql = "DELETE FROM cart WHERE user_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    //allorder user
	@Override
	public List<Orders> getAllOrders()  {
		// TODO Auto-generated method stub
		  List<Orders> list = new ArrayList<>();
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/shopping", "root","Shubham@1132");
			String sql= "SELECT * FROM orders";

			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Orders o=new Orders();
			
				o.setOrderId(rs.getInt("order_id"));
				  o.setUserId(rs.getInt("user_id"));
		            o.setTotalAmount(rs.getDouble("total_amount"));
		            o.setPaymentMethod(rs.getString("payment_method"));
		            o.setAddress(rs.getString("address"));
		            o.setPhone(rs.getString("phone"));
		            o.setOrderDate(rs.getString("order_date"));
		            o.setStatus(rs.getString("status"));

		            list.add(o);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	//myorders
	@Override
	public List<Orders> getMyOrders(int userId) {

	    List<Orders> list = new ArrayList<>();

	    try {

	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection con =
	                DriverManager.getConnection(
	                        "jdbc:mysql://localhost:3306/shopping",
	                        "root",
	                        "Shubham@1132");

	        String sql =
	                "SELECT * FROM orders WHERE user_id=? ORDER BY order_date DESC";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setInt(1, userId);

	        ResultSet rs = ps.executeQuery();

	        while(rs.next()){

	            Orders o = new Orders();

	            o.setOrderId(rs.getInt("order_id"));
	            o.setUserId(rs.getInt("user_id"));
	            o.setTotalAmount(rs.getDouble("total_amount"));
	            o.setPaymentMethod(rs.getString("payment_method"));
	            o.setAddress(rs.getString("address"));
	            o.setPhone(rs.getString("phone"));
	            o.setOrderDate(rs.getString("order_date"));
	            o.setStatus(rs.getString("status"));

	            list.add(o);
	        }

	        con.close();

	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }

	    return list;
	} 
	
	
	//cancel order
	public boolean cancelOrder(int orderId){

	    try{

	        Class.forName(
	                "com.mysql.cj.jdbc.Driver");

	        Connection con =
	                DriverManager.getConnection(
	                        "jdbc:mysql://localhost:3306/shopping",
	                        "root",
	                        "Shubham@1132");

	        String sql =
	        "update orders set status='CANCELLED' where order_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setInt(1, orderId);

	        int rows =
	                ps.executeUpdate();

	        con.close();

	        return rows>0;

	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }

	    return false;
	}
	
	
	//updaate status
	public boolean updateStatus(int orderId,String status){

		try{

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con=
		DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/shopping",
		"root",
		"Shubham@1132");

		String sql=
		"update orders set status=? where order_id=?";

		PreparedStatement ps=
		con.prepareStatement(sql);

		ps.setString(1,status);
		ps.setInt(2,orderId);

		return ps.executeUpdate()>0;

		}
		catch(Exception e){

		e.printStackTrace();

		}

		return false;

		}
	
}