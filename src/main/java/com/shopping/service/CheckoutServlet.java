package com.shopping.service;

import java.io.IOException;
import java.util.List;

import com.shopping.logic.CartBussinessLogic;
import com.shopping.model.CartItem;
import com.shopping.model.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
		 HttpSession session = req.getSession(false);

	        if(session == null || session.getAttribute("user") == null){
	            res.sendRedirect("login.jsp");
	            return;
	        }

Users user = (Users) session.getAttribute("user");
CartBussinessLogic logic=new CartBussinessLogic();
List<CartItem> list = logic.viewCart(user.getUserId());
if(list == null || list.isEmpty()){

    RequestDispatcher rd =
    req.getRequestDispatcher("cartEmpty.jsp");

    rd.forward(req, res);
    return;
}
req.setAttribute("cartList", list);
RequestDispatcher rd =
req.getRequestDispatcher("checkout.jsp");

rd.forward(req, res);
}
}
