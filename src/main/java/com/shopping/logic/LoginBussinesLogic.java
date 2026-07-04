package com.shopping.logic;
import com.shopping.connectivity.*;
import com.shopping.database.*;
import com.shopping.model.Users;
public class LoginBussinesLogic {
public Users checkLogin(String email,String pwd) {
	if(email == null || email.trim().equals("") ||
			   pwd== null || pwd.trim().equals("")) {

			    return null;
			}
	LoginConnectivity ref=new LoginDatabase();
	return ref.userLogin(email,pwd);
	
}
}
