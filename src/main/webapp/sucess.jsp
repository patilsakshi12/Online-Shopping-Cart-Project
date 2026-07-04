<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.util.*,com.shopping.model.CartItem"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Success</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    font-family:Arial, sans-serif;
    background:linear-gradient(to right,#eef3fb,#dfefff);
    padding:30px;
}

.container{
    width:850px;
    margin:auto;
    background:white;
    padding:30px;
    border-radius:15px;
    box-shadow:0px 5px 20px rgba(0,0,0,0.15);
    text-align:center;
}

h1{
    color:#28a745;
    margin-bottom:20px;
}

.box{
    text-align:left;
    margin-top:20px;
    padding:20px;
    border-radius:10px;
    background:#f8f9fa;
    border-left:5px solid #28a745;
}

.box h3{
    color:#23407a;
    margin-bottom:15px;
}

.box p{
    margin:8px 0;
    font-size:16px;
}

table{
    width:100%;
    border-collapse:collapse;
    margin-top:15px;
}

th{
    background:#23407a;
    color:white;
}

th,td{
    border:1px solid #ddd;
    padding:12px;
    text-align:center;
}

tr:nth-child(even){
    background:#f8f9fa;
}

.total-row{
    background:#e8f5e9;
    font-weight:bold;
}

.payment{
    margin-top:15px;
    font-size:17px;
    color:#23407a;
    font-weight:bold;
}

.btn{
    padding:12px 25px;
    margin:15px 10px;
    border:none;
    color:white;
    cursor:pointer;
    border-radius:25px;
    font-size:15px;
    font-weight:bold;
}

.home{
    background:#28a745;
}

.home:hover{
    background:#218838;
}

.logout{
    background:#dc3545;
}

.logout:hover{
    background:#c82333;
}

</style>

</head>

<body>

<div class="container">

<h1>🎉 Order Placed Successfully!</h1>

<%
Integer orderId = (Integer)request.getAttribute("orderId");
String address = (String)request.getAttribute("address");
String payment = (String)request.getAttribute("payment");
Double total = (Double)request.getAttribute("total");

List<CartItem> items =
(List<CartItem>)request.getAttribute("orderItems");
%>

<!-- Order Details -->
<div class="box">

<h3>Order Details</h3>

<p>
    <b>Order ID :</b>
    <%= orderId %>
</p>

<p>
    <b>Shipping Address :</b>
    <%= address %>
</p>

</div>

<!-- Order Summary -->
<div class="box">

<h3>Order Summary</h3>

<table>

<tr>
    <th>Product</th>
    <th>Price</th>
    <th>Qty</th>
    <th>Total</th>
</tr>

<%
double grandTotal = 0;

if(items != null){

for(CartItem item : items){

double t =
item.getPrice() * item.getQuantity();

grandTotal += t;
%>

<tr>
    <td><%= item.getProductName() %></td>
    <td>₹<%= item.getPrice() %></td>
    <td><%= item.getQuantity() %></td>
    <td>₹<%= t %></td>
</tr>

<%
}
}
%>

<tr class="total-row">
    <td colspan="3">
        <b>Total Amount</b>
    </td>
    <td>
        <b>₹<%= grandTotal %></b>
    </td>
</tr>

</table>

<p class="payment">
    Payment Method :
    <%= payment %>
</p>

</div>

<br>

<a href="products">
    <button class="btn home">
        Continue Shopping
    </button>
</a>


</a>

<a href="logout">
    <button class="btn logout">
        Logout
    </button>
</a>

</div>

</body>
</html>