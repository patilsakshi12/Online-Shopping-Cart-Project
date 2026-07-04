package com.shopping.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.logic.ProductBussinessLogic;
import com.shopping.model.CartItem;
import com.shopping.model.Products;
import com.shopping.model.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/buyNow")
public class BuyNowServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
            HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if(session == null || session.getAttribute("user") == null){
            res.sendRedirect("login.jsp");
            return;
        }

        int productId =
                Integer.parseInt(req.getParameter("productId"));

        ProductBussinessLogic logic =
                new ProductBussinessLogic();

        Products p =
                logic.getProductById(productId);

        CartItem item = new CartItem();

        item.setProductId(p.getProductId());
        item.setProductName(p.getProductName());
        item.setPrice(p.getPrice());
        item.setQuantity(1);
        item.setImage(p.getImage());

        List<CartItem> list =
                new ArrayList<>();

        list.add(item);

        req.setAttribute("cartList", list);

        req.setAttribute("buyNow", true);

        RequestDispatcher rd =
                req.getRequestDispatcher("checkout.jsp");

        rd.forward(req, res);

    }

}