package com.shopping.database;
import com.shopping.model.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.connectivity.LoginConnectivity;
import com.shopping.model.Users;

public class LoginDatabase implements LoginConnectivity {

	@Override
	public Users userLogin(String email, String pwd) {
		// TODO Auto-generated method stub
		Users user=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","Shubham@1132");
			String query="select* from users where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				user=new Users();
				user.setUserId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));	
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

}
