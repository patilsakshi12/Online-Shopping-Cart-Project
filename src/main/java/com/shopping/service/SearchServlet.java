package com.shopping.service;

import java.io.IOException;
import java.util.List;

import com.shopping.logic.ProductBussinessLogic;
import com.shopping.model.Products;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SearchProductServlet")
public class SearchServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		 HttpSession session = req.getSession(false);

	        if(session == null || session.getAttribute("user") == null){
	            res.sendRedirect("login.jsp");
	            return;
	        }
		  String keyword = req.getParameter("keyword");
		  ProductBussinessLogic ref=new ProductBussinessLogic();
		  List<Products> list = ref.searchProducts(keyword);
		  req.setAttribute("products", list);

	        RequestDispatcher rd =
	                req.getRequestDispatcher("products.jsp");

	        rd.forward(req, res);
		  
		 
	 }
}
