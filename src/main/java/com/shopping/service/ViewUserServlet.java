package com.shopping.service;

import java.io.IOException;
import java.util.List;

import com.shopping.logic.UserBusinessLogic;
import com.shopping.model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewUsers")
public class ViewUserServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);

	        if(session == null || session.getAttribute("user") == null){
	            response.sendRedirect("login.jsp");
	            return;
	        }
		  UserBusinessLogic logic =new UserBusinessLogic();
		  
		  List<Users> user=logic.getAllUsers();
		  request.setAttribute("users", user);

	        request.getRequestDispatcher("viewUsers.jsp")
	               .forward(request, response);
	}
}
