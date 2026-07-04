package com.shopping.service;

import java.io.IOException;

import com.shopping.logic.OrderBussinessLogic;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateOrderStatusServlet")
public class UpdateOrderStatusServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,	HttpServletResponse res) throws IOException {
		int orderId=Integer.parseInt(req.getParameter("orderId"));
		String status=req.getParameter("status");
		OrderBussinessLogic logic=new OrderBussinessLogic();
		logic.updateStatus(orderId,status);
		res.sendRedirect("viewOrders");
}
}