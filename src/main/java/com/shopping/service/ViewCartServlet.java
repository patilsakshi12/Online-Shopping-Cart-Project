package com.shopping.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import com.shopping.logic.CartBussinessLogic;
import com.shopping.model.Users;
import com.shopping.model.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/viewCart")

public class ViewCartServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,
            HttpServletResponse res) throws ServletException, IOException {
		 HttpSession session = req.getSession(false);

	        if(session == null || session.getAttribute("user") == null){
	            res.sendRedirect("login.jsp");
	            return;
	        }
        
        Users user=(Users)session.getAttribute("user");
        int userId = user.getUserId();
        
        CartBussinessLogic logic = new CartBussinessLogic();
       List<CartItem> list =logic.viewCart(userId);
       
       req.setAttribute("cartList",list);
       RequestDispatcher rd=req.getRequestDispatcher("cart.jsp");
       rd.forward(req, res);
        
	}
}
