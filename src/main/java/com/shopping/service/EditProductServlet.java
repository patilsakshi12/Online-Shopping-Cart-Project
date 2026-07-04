package com.shopping.service;

import java.io.IOException;

import com.shopping.logic.ProductBussinessLogic;
import com.shopping.model.Products;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 HttpSession session = request.getSession(false);

	        if(session == null || session.getAttribute("user") == null){
	            response.sendRedirect("login.jsp");
	            return;
	        }

    	int id = Integer.parseInt(request.getParameter("id"));

    //	System.out.println("Product ID = " + id);

    	ProductBussinessLogic logic = new ProductBussinessLogic();

    	Products p = logic.getProductById(id);

    	//System.out.println("Product Object = " + p);

    	request.setAttribute("product", p);

    	request.getRequestDispatcher("editProduct.jsp")
    	       .forward(request, response);
    }
}