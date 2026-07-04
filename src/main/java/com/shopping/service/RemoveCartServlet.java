package com.shopping.service;

import java.io.IOException;
import java.io.PrintWriter;

import com.shopping.logic.CartBussinessLogic;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		 HttpSession session = req.getSession(false);

	        if(session == null || session.getAttribute("user") == null){
	            res.sendRedirect("login.jsp");
	            return;
	        }
		int cardId= Integer.parseInt(req.getParameter("cartId"));
		
	CartBussinessLogic ref= new CartBussinessLogic();
	boolean result= ref.removeItem(cardId);
	PrintWriter out=res.getWriter();
		if(result==true) {
			res.sendRedirect("viewCart");
		}
		else {
			out.println("Remove failed");
		}
	}
}
