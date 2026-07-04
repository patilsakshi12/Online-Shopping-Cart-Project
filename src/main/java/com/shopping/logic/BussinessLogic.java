package com.shopping.logic;
import com.shopping.connectivity.RegisterConnectivity;
import com.shopping.database.*;
public class BussinessLogic {
public boolean registerUser(String name,String email,String password, String role) {
	
	if(name == null || name.trim().equals("") ||
		       email == null || email.trim().equals("") ||
		       password == null || password.trim().equals("")) {

		        return false;
		    }

	RegisterConnectivity ref=new RegisterDatabase();
	return ref.insertUser(name,email,password,role);
	
}
}
