
	package com.shopping.service;

	import java.io.IOException;
	import java.util.List;

	import com.shopping.logic.OrderBussinessLogic;
	import com.shopping.model.Orders;
	import com.shopping.model.Users;

	import jakarta.servlet.RequestDispatcher;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import jakarta.servlet.http.HttpSession;

	@WebServlet("/myOrders")
	public class MyOrdersServlet extends HttpServlet {

	    public void doGet(HttpServletRequest req,
	                      HttpServletResponse res)
	            throws ServletException, IOException {

	        HttpSession session = req.getSession(false);

	        Users user = (Users) session.getAttribute("user");

	        int userId = user.getUserId();

	        OrderBussinessLogic logic =
	                new OrderBussinessLogic();

	        List<Orders> list =
	                logic.getMyOrders(userId);

	        req.setAttribute("orders", list);

	        RequestDispatcher rd =
	                req.getRequestDispatcher("myOrders.jsp");

	        rd.forward(req, res);
	    }
	}
