package com.shopping.service;

import java.io.IOException;

import com.shopping.logic.ProductBussinessLogic;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
		 HttpSession session = request.getSession(false);

	        if(session == null || session.getAttribute("user") == null){
	            response.sendRedirect("login.jsp");
	            return;
	        }
		 int id = Integer.parseInt(request.getParameter("id"));
		 ProductBussinessLogic ref=new ProductBussinessLogic();
		 boolean result=ref.deleteProduct(id);
		 if(result) {
			 response.sendRedirect("viewProductsAdmin");
		 }
		 else {
			  response.getWriter().println("Product Delete Failed");
		 }
	}
}
