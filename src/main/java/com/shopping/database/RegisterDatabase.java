package com.shopping.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shopping.connectivity.RegisterConnectivity;

public class RegisterDatabase implements RegisterConnectivity{

	@Override
	public boolean insertUser(String v1, String v2, String v3, String v4) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","Shubham@1132");
			String query="insert into users (name,email,password,role) values (?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, v1);
			ps.setString(2, v2);
			ps.setString(3, v3);
			ps.setString(4, v4);
			
			int r=ps.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		// TODO Auto-generated method stub
		
	}

}
