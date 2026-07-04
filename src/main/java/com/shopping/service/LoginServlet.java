package com.shopping.service;
import com.shopping.model.*;
import java.io.IOException;
import java.io.PrintWriter;

import com.shopping.logic.LoginBussinesLogic;
import com.shopping.model.Users;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String email=req.getParameter("email");
		String pwd=req.getParameter("password");
		
		LoginBussinesLogic l1=new LoginBussinesLogic();
		Users user= l1.checkLogin(email, pwd);
		 PrintWriter out=res.getWriter();
		 if(user!=null) {
			 HttpSession session = req.getSession();
			   
	            session.setAttribute("user", user);
	            
	            if("admin".equals(user.getRole())) {
	            	res.sendRedirect("adminDashboard.jsp");
	            }
	            else  {
	            res.sendRedirect("products");	
	            }
		 }
	            
		else {
	            	out.println("Invalid Login");
	          }

		 }
	}


