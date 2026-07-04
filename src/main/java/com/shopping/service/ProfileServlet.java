package com.shopping.service;

import java.io.IOException;

import com.shopping.model.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session =
                req.getSession(false);

        if(session == null ||
           session.getAttribute("user") == null){

            res.sendRedirect("login.jsp");
            return;
        }

        Users user =
                (Users)session.getAttribute("user");

        req.setAttribute("user", user);

        RequestDispatcher rd =
                req.getRequestDispatcher("profile.jsp");

        rd.forward(req, res);
    }
}