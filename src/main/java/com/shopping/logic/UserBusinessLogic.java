package com.shopping.logic;

import java.util.List;
import com.shopping.connectivity.*;
import com.shopping.database.*;
import org.apache.catalina.startup.UserConfig;

import com.shopping.model.Users;

public class UserBusinessLogic {

	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		UserConnectivity ref=new UserDatabase();
		
		return ref.getAllUsers();
		 
	}

}
