package com.shopping.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.connectivity.ProductConnectivity;
import com.shopping.model.Products;

public class ProductDatabase implements ProductConnectivity{

	@Override
	public List<Products> getAllProduct() {
		// TODO Auto-generated method stub
		  List<Products> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","Shubham@1132");
			String query="Select * From Products";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Products p = new Products
                	(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("description"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    rs.getString("image")
                );
                list.add(p);
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
	
	@Override
	public boolean addProduct(Products p) {

	    try {

	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection con =
	            DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/shopping",
	            "root",
	            "Shubham@1132");

	        String sql =
	        "insert into products(product_name,description,price,category,quantity,image) values(?,?,?,?,?,?)";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setString(1, p.getProductName());
	        ps.setString(2, p.getDescription());
	        ps.setDouble(3, p.getPrice());
	        ps.setString(4, p.getCategory());
	        ps.setInt(5, p.getQuantity());
	        ps.setString(6, p.getImage());

	        int i = ps.executeUpdate();

	        if(i > 0) {
	            return true;
	        }

	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}

	@Override
	public Products getProductById(int id) {
		// TODO Auto-generated method stub
		
		

		    Products p = null;

		    try {
		    	Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","Shubham@1132");

		        String sql = "SELECT * FROM products WHERE product_id=?";

		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setInt(1, id);

		        ResultSet rs = ps.executeQuery();

		        if(rs.next()) {
		            p = new Products();

		            p.setProductId(rs.getInt("product_id"));
		            p.setProductName(rs.getString("product_name"));
		            p.setDescription(rs.getString("description"));
		            p.setPrice(rs.getDouble("price"));
		            p.setCategory(rs.getString("category"));
		            p.setQuantity(rs.getInt("quantity"));
		            p.setImage(rs.getString("image"));
		        }

		    } catch(Exception e) {
		        e.printStackTrace();
		    }

		    return p;
	
	}
	public boolean updateProduct(Products p) {

	    try {

	       
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","Shubham@1132");
	        String sql =
	        "update products set product_name=?, description=?, category=?, price=?, quantity=?, image=? where product_id=?";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, p.getProductName());
	        ps.setString(2, p.getDescription());
	        ps.setString(3, p.getCategory());
	        ps.setDouble(4, p.getPrice());
	        ps.setInt(5, p.getQuantity());
	        ps.setString(6, p.getImage());
	        ps.setInt(7, p.getProductId());

	        int i = ps.executeUpdate();

	        if(i > 0) {
	            return true;
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}
	@Override
	public boolean deleteProduct(int id) {

	    try {

	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/shopping",
	                "root",
	                "Shubham@1132");

	        String sql = "delete from products where product_id=?";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, id);

	        int i = ps.executeUpdate();

	        if(i > 0) {
	            return true;
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}

}
