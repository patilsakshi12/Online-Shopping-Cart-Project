package com.shopping.service;

import com.shopping.model.Cart;
import com.shopping.model.Users;

import java.io.IOException;
import java.io.PrintWriter;

import com.shopping.*;
import com.shopping.logic.CartBussinessLogic;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		 HttpSession session = req.getSession(false);

	        if(session == null || session.getAttribute("user") == null){
	            res.sendRedirect("login.jsp");
	            return;
	        }
		//receive product id
		int productId=Integer.parseInt( req.getParameter("productId"));
		
		//logged user
		Users user=(Users)session.getAttribute("user");
		
		int userId=user.getUserId();
		//cart object
		Cart cart=new Cart();
		cart.setUserId(userId);
		cart.setProductId(productId);
		cart.setQuantity(1);
		
		//service object
		 CartBussinessLogic ref=new  CartBussinessLogic();
		boolean result=ref.addToCart(cart);
		PrintWriter out=res.getWriter();
		if(result==true) {
			res.sendRedirect("products?msg=added");
		
			
		}
		else {
			out.println("Add To Cart Failed");
		}
	}

}
