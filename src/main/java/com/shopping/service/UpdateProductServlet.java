package com.shopping.service;

import java.io.IOException;

import com.shopping.logic.ProductBussinessLogic;
import com.shopping.model.Products;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    	 HttpSession session = request.getSession(false);

	        if(session == null || session.getAttribute("user") == null){
	            response.sendRedirect("login.jsp");
	            return;
	        }
        int id = Integer.parseInt(request.getParameter("productId"));
        String name = request.getParameter("productName");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String image = request.getParameter("image");

        Products p = new Products();

        p.setProductId(id);
        p.setProductName(name);
        p.setDescription(description);
        p.setCategory(category);
        p.setPrice(price);
        p.setQuantity(quantity);
        p.setImage(image);

        ProductBussinessLogic logic = new ProductBussinessLogic();

        boolean status = logic.updateProduct(p);

        if(status) {
            response.sendRedirect("viewProductsAdmin");
        }
        else {
            response.getWriter().println("Product Update Failed");
        }
    }
}