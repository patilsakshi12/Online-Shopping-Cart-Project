package com.shopping.service;

import java.io.IOException;

import com.shopping.logic.ProductBussinessLogic;
import com.shopping.model.Products;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet   {
	protected void doPost(HttpServletRequest req,
            HttpServletResponse res) throws IOException {
		 HttpSession session = req.getSession(false);

	        if(session == null || session.getAttribute("user") == null){
	            res.sendRedirect("login.jsp");
	            return;
	        }
		 String productName =
	                req.getParameter("productName");

	        String description =
	                req.getParameter("description");

	        double price =
	                Double.parseDouble(
	                        req.getParameter("price"));

	        String category =
	                req.getParameter("category");

	        int quantity =
	                Integer.parseInt(
	                        req.getParameter("quantity"));

	        String image =
	                req.getParameter("image");
	        

	        Products p = new Products();

	        p.setProductName(productName);
	        p.setDescription(description);
	        p.setPrice(price);
	        p.setCategory(category);
	        p.setQuantity(quantity);
	        p.setImage(image);

	        ProductBussinessLogic ref =
	                new ProductBussinessLogic();

	        boolean status =
	                ref.addProduct(p);
	        if(status) {
	        	   res.sendRedirect("viewProductsAdmin");
	        }
	        else {
	            res.getWriter().println("Product Not Added");
	        }
	}
}
