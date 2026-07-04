package com.shopping.service;

import java.io.IOException;

import com.shopping.logic.OrderBussinessLogic;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cancelOrder")
public class CancleOrderServlet extends HttpServlet {

    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
            throws IOException {

        int orderId =
                Integer.parseInt(
                        req.getParameter("orderId"));

        OrderBussinessLogic logic =
                new OrderBussinessLogic();

        boolean result =
                logic.cancelOrder(orderId);

        if(result){
            res.sendRedirect("myOrders");
        }
        else{
            res.getWriter().println("Order Cancel Failed");
        }
    }
}