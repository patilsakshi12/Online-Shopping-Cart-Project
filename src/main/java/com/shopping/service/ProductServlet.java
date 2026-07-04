package com.shopping.service;
import com.shopping.model.*;

import java.io.IOException;
import java.util.List;
import com.shopping.logic.ProductBussinessLogic;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/products")
public class ProductServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	 HttpSession session = req.getSession(false);

     if(session == null || session.getAttribute("user") == null){
         res.sendRedirect("login.jsp");
         return;
     }
	ProductBussinessLogic p=new ProductBussinessLogic();
	List<Products> list = p.getProducts();
	

	
	 req.setAttribute("products", list);
	 String msg = req.getParameter("msg");
		req.setAttribute("msg", msg);
     RequestDispatcher rd=req.getRequestDispatcher("products.jsp");
     rd.forward(req, res);

}
}