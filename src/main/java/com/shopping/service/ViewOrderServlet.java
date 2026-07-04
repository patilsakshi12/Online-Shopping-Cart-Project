package com.shopping.service;

import java.io.IOException;
import java.util.List;

import com.shopping.logic.OrderBussinessLogic;
import com.shopping.model.Orders;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewOrders")
public class ViewOrderServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	 HttpSession session = req.getSession(false);

     if(session == null || session.getAttribute("user") == null){
         res.sendRedirect("login.jsp");
         return;
     }
	OrderBussinessLogic logic=new OrderBussinessLogic();
	List<Orders> order=logic.getAllOrders();
	//System.out.println("Size = " + order.size());

	req.setAttribute("orders", order);
	RequestDispatcher rd=req.getRequestDispatcher("viewOrders.jsp");
	rd.forward(req, res);
	
}
}
