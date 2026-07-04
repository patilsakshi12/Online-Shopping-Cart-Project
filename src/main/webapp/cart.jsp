<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.shopping.model.CartItem"%>


<%
if(session == null || session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
    return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Cart</title>

<style>

body{
    font-family: Arial, sans-serif;
    background:#eef3fb;
    margin:0;
    padding:20px;
}

h2{
    text-align:center;
    color:#23407a;
}

/* Cart Card */
.cart-box{
    width:750px;
    background:white;
    border-radius:12px;
    padding:20px;
    margin:20px auto;
    box-shadow:0px 2px 10px rgba(0,0,0,0.15);

    display:flex;
    align-items:center;
    gap:20px;
}

.cart-box img{
    width:120px;
    height:120px;
    object-fit:contain;
}

/* Product Details */
.product-info{
    flex:1;
}

.product-info h3{
    margin:0;
    color:#23407a;
}

.product-info p{
    margin:8px 0;
    font-size:16px;
}

/* Remove Button */
.remove-btn{
    padding:10px 20px;
    background:red;
    color:white;
    border:none;
    border-radius:20px;
    cursor:pointer;
    font-weight:bold;
}

.remove-btn:hover{
    background:darkred;
}

/* Total Box */
.total-box{
    width:750px;
    margin:20px auto;
    background:white;
    padding:20px;
    border-radius:12px;
    text-align:center;
    box-shadow:0px 2px 10px rgba(0,0,0,0.15);
}

/* Checkout Button */
.checkout-btn{
    padding:12px 30px;
    background:#28a745;
    color:white;
    border:none;
    border-radius:25px;
    cursor:pointer;
    font-size:16px;
    font-weight:bold;
    margin-top:10px;
}

.checkout-btn:hover{
    background:#218838;
}
.qty-btn{
    display:inline-block;
    width:30px;
    height:30px;
    line-height:30px;
    text-align:center;
    text-decoration:none;
    background:#23407a;
    color:white;
    border-radius:50%;
    font-weight:bold;
    margin:0 8px;
}

.qty-btn:hover{
    background:#28a745;
}

.qty{
    font-size:18px;
    font-weight:bold;
    margin:0 5px;
}
</style>

</head>
<body>

<h2>🛒 My Cart</h2>

<%
List<CartItem> list =
(List<CartItem>)request.getAttribute("cartList");

double total = 0;

if(list != null){

for(CartItem item : list){

    total += item.getPrice() * item.getQuantity();
%>

<div class="cart-box">

    <img src="images/<%= item.getImage() %>" alt="Product">

    <div class="product-info">

        <h3><%= item.getProductName() %></h3>

        <p>
            <b>Price :</b>
            ₹ <%= item.getPrice() %>
        </p>

     <p>
  <b>Quantity :</b>

    <a href="UpdateCartServlet?action=decrease&cartId=<%=item.getCartId()%>"
    class="qty-btn">−</a>

 <span class="qty">
    <%= item.getQuantity() %>
</span>

<a href="UpdateCartServlet?action=increase&cartId=<%=item.getCartId()%>"
class="qty-btn">+</a>

</p>
        <p>
            <b>Total :</b>
            ₹ <%= item.getPrice() * item.getQuantity() %>
        </p>

    </div>

    <a href="RemoveCartServlet?cartId=<%= item.getCartId() %>">

        <button class="remove-btn">
            Remove
        </button>

    </a>

</div>

<%
}
}
%>

<div class="total-box">

    <h2>
        Total Amount : ₹<%= total %>
    </h2>

    <form action="checkout" method="get">

        <input type="submit"
               value="Proceed To Checkout"
               class="checkout-btn">

    </form>

</div>

</body>
</html>