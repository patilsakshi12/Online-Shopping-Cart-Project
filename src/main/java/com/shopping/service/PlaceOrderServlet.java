
package com.shopping.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.logic.CartBussinessLogic;
import com.shopping.logic.OrderBussinessLogic;
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

@WebServlet("/placeOrder")
public class PlaceOrderServlet extends HttpServlet {

    public void doPost(HttpServletRequest req,
            HttpServletResponse res)
            throws IOException, ServletException {

        HttpSession session = req.getSession(false);

        if(session == null || session.getAttribute("user")==null){
            res.sendRedirect("login.jsp");
            return;
        }

        Users user = (Users)session.getAttribute("user");

        int userId = user.getUserId();

        double total =
        Double.parseDouble(req.getParameter("total"));

        String payment =
        req.getParameter("payment");

        String address =
        req.getParameter("address");

        String phone =
        req.getParameter("phone");

        String buyNow =
        req.getParameter("buyNow");

        OrderBussinessLogic logic =
        new OrderBussinessLogic();

        CartBussinessLogic cartLogic =
        new CartBussinessLogic();

        List<CartItem> items = new ArrayList<>();

        int orderId = 0;

        // BUY NOW
        if("true".equals(buyNow)){

            int productId =
            Integer.parseInt(req.getParameter("productId"));

            ProductBussinessLogic productLogic =
            new ProductBussinessLogic();

            Products p =
            productLogic.getProductById(productId);

            CartItem item = new CartItem();

            item.setProductId(p.getProductId());
            item.setProductName(p.getProductName());
            item.setPrice(p.getPrice());
            item.setQuantity(1);
            item.setImage(p.getImage());

            items.add(item);

            orderId =
            logic.placeBuyNowOrder(
                    userId,
                    productId,
                    total,
                    payment,
                    address,
                    phone);

        }

        // CART CHECKOUT
        else{

            items =
            cartLogic.viewCart(userId);
            if(items == null || items.isEmpty()){

                RequestDispatcher rd =
                req.getRequestDispatcher("cartEmpty.jsp");

                rd.forward(req, res);

                return;
            }

            orderId =
            logic.placeOrder(
                    userId,
                    total,
                    payment,
                    address,
                    phone);

            if(orderId > 0){
                cartLogic.clearCart(userId);
            }

        }

        if(orderId > 0){

            req.setAttribute("orderId", orderId);
            req.setAttribute("address", address);
            req.setAttribute("payment", payment);
            req.setAttribute("total", total);
            req.setAttribute("orderItems", items);

            RequestDispatcher rd =
            req.getRequestDispatcher("sucess.jsp");

            rd.forward(req, res);

        }
        else{

        	 RequestDispatcher rd =
        	            req.getRequestDispatcher("orderFailed.jsp");

        	            rd.forward(req, res);


        }

    }

}

