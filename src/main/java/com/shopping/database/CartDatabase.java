package com.shopping.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.shopping.model.CartItem;

import com.shopping.connectivity.CartConnectivity;
import com.shopping.model.Cart;

public class CartDatabase implements CartConnectivity{

	//addtocart
	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","Shubham@1132");
			   // CHECK product already exists or not
	        String checkQuery =
	        "SELECT * FROM cart WHERE user_id=? AND product_id=?";
	        
	        PreparedStatement checkPs =con.prepareStatement(checkQuery);

	                checkPs.setInt(1, cart.getUserId());
	                checkPs.setInt(2, cart.getProductId());
	                ResultSet rs = checkPs.executeQuery();
	                
	                // PRODUCT ALREADY EXISTS
	                if(rs.next()) {

	                    String updateQuery =
	                    "UPDATE cart SET quantity = quantity + 1 " +
	                    "WHERE user_id=? AND product_id=?";

	                    PreparedStatement updatePs =
	                    con.prepareStatement(updateQuery);

	                    updatePs.setInt(1, cart.getUserId());
	                    updatePs.setInt(2, cart.getProductId());

	                    int updated = updatePs.executeUpdate();

	                    return updated > 0;
	                }

	                
	                // PRODUCT NOT EXISTS → INSERT
	                else {

	                    String insertQuery =
	                    "INSERT INTO cart(user_id, product_id, quantity) VALUES(?,?,?)";

	                    PreparedStatement insertPs =
	                    con.prepareStatement(insertQuery);

	                    insertPs.setInt(1, cart.getUserId());
	                    insertPs.setInt(2, cart.getProductId());
	                    insertPs.setInt(3, cart.getQuantity());

	                    int inserted = insertPs.executeUpdate();

	                    return inserted > 0;
	                }
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	
	//view cart
	@Override
	public List<CartItem> getCartItmes(int userId) {
		// TODO Auto-generated method stub
		   List<CartItem> list = new ArrayList<>();
		   
		   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/shopping", "root", "Shubham@1132");
			 String query = 
					 "SELECT * FROM cart c " +
							 "JOIN products p " +
							 "ON c.product_id = p.product_id " +
							 "WHERE c.user_id = ?";
			            
			 PreparedStatement ps=con.prepareStatement(query);
			 ps.setInt(1, userId);
		      ResultSet rs = ps.executeQuery();
		      while(rs.next()) {
		    	     
		    	  CartItem item=new CartItem();
                  
		    	  item.setCartId(rs.getInt("cart_id"));
		    	  item.setProductName(rs.getString("product_name"));
		    	  item.setPrice(rs.getDouble("price"));
		    	  item.setQuantity(rs.getInt("quantity"));
		    	  item.setImage(rs.getString("image"));

	                list.add(item);
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


	
	//remove cartItems
	@Override
	public boolean removeCartItem(int cardId) {
		// TODO Auto-generated method stub
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","Shubham@1132");
			String query="Delete from cart where cart_id=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, cardId);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public boolean clearCart(int userId) {
		// TODO Auto-generated method stub
	

		    try {
		        Connection con = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/shopping",
		            "root",
		            "Shubham@1132"
		        );

		        String sql = "DELETE FROM cart WHERE user_id=?";
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setInt(1, userId);

		        return ps.executeUpdate() > 0;

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return false;
		}


	@Override
	public boolean increaseQuantity(int cardId)  {
		// TODO Auto-generated method 
      try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/shopping",
		            "root",
		            "Shubham@1132"
		        );
		  String query="UPDATE cart SET quantity = quantity + 1 WHERE cart_id = ?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, cardId);
	    int rs=ps.executeUpdate();
	    return rs>0;
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}


	@Override
	public boolean decreaseQuantity(int cardId) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection con = DriverManager.getConnection(
			            "jdbc:mysql://localhost:3306/shopping",
			            "root",
			            "Shubham@1132"
			        );
			  String query="UPDATE cart SET quantity = quantity - 1 WHERE cart_id = ?";;
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, cardId);
			int rs=ps.executeUpdate();
			return rs>0;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	}
	
	
	
	
	
	
	




