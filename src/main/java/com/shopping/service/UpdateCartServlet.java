package com.shopping.service;
import java.io.IOException;

import com.shopping.logic.CartBussinessLogic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {

        int cartId =
        Integer.parseInt(req.getParameter("cartId"));

        String action =
        req.getParameter("action");

        CartBussinessLogic logic = new CartBussinessLogic();



        if(action.equals("increase")){

            logic.increaseQuantity(cartId);

        }
        else if(action.equals("decrease")){

            logic.decreaseQuantity(cartId);

        }

        res.sendRedirect("viewCart");

    }

}