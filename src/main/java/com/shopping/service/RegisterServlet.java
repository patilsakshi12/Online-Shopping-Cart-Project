package com.shopping.service;

import java.io.IOException;
import java.io.PrintWriter;

import com.shopping.logic.BussinessLogic;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
    System.out.println(name);
    System.out.println(email);
    System.out.println(password);
	
	String role="Customer";
	
	BussinessLogic ref=new BussinessLogic();
	boolean result=ref.registerUser(name,email,password,role);
	PrintWriter out=res.getWriter();
	if(result==true) {
		 //out.println("<h1>Registration Successful</h1>");
		  res.sendRedirect("login.jsp");
	}
	else {
		  res.sendRedirect("register.html");
	}
}
}
