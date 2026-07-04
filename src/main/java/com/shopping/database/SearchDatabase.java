package com.shopping.database;

import com.shopping.model.Products;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.connectivity.SearchConnectivity;
import com.shopping.model.Products;

public class SearchDatabase implements SearchConnectivity {

	@Override
	public List<Products> searchByProducts(String keyword) {
		// TODO Auto-generated method stub
		 List<Products> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(
				    "jdbc:mysql://localhost:3306/shopping",
				    "root",
				    "Shubham@1132");
			 String sql =
			            "select * from products where product_name like ?";

			        PreparedStatement ps =
			            con.prepareStatement(sql);

			        ps.setString(1, "%" + keyword + "%");

			        ResultSet rs = ps.executeQuery();

			        while(rs.next()) {

			            Products p = new Products();

			            

			            p.setProductId(rs.getInt("product_id"));
			            p.setProductName(rs.getString("product_name"));
			            p.setDescription(rs.getString("description"));
			            p.setPrice(rs.getDouble("price"));
			            p.setImage(rs.getString("image"));

			            list.add(p);
			        }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list ;
	}

	
	

}
