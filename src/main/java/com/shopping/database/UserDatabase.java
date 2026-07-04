package com.shopping.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shopping.connectivity.UserConnectivity;
import com.shopping.model.Users;

public class UserDatabase implements  UserConnectivity {

	public List<Users> getAllUsers() {

	    List<Users> list = new ArrayList<>();

	    try {

	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/shopping",
	                "root",
	                "Shubham@1132");

	        String sql = "select * from users";

	        PreparedStatement ps =con.prepareStatement(sql);

	        ResultSet rs = ps.executeQuery();

	        while(rs.next()) {

	            Users u = new Users();

	            u.setUserId(rs.getInt("id"));
	            u.setName(rs.getString("name"));
	            u.setEmail(rs.getString("email"));
	            u.setPassword(rs.getString("password"));
	            u.setRole(rs.getString("role"));

	            list.add(u);
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}

}
