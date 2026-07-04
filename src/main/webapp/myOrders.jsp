<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.util.*,com.shopping.model.Orders"%>

<%
if(session==null || session.getAttribute("user")==null){
    response.sendRedirect("login.jsp");
    return;
}

List<Orders> orders=
(List<Orders>)request.getAttribute("orders");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Orders</title>

<style>

body{
    font-family:Arial,sans-serif;
    background:#eef2f7;
    margin:0;
    padding:20px;
}

h2{
    text-align:center;
    color:#23407a;
    margin-bottom:20px;
}

table{
    width:95%;
    margin:auto;
    border-collapse:collapse;
    background:white;
    box-shadow:0 0 10px lightgray;
}

th{
    background:#23407a;
    color:white;
    padding:12px;
}

td{
    text-align:center;
    padding:12px;
    border-bottom:1px solid #ddd;
}

tr:hover{
    background:#f5f5f5;
}

.pending{
    color:orange;
    font-weight:bold;
}

.success{
    color:green;
    font-weight:bold;
}

.shifted{
    color:#007bff;
    font-weight:bold;
}

.delivered{
    color:#28a745;
    font-weight:bold;
}

.cancelled{
    color:red;
    font-weight:bold;
}

.btn{
    padding:8px 15px;
    border:none;
    border-radius:5px;
    color:white;
    cursor:pointer;
    font-weight:bold;
}

.cancel{
    background:red;
}

.cancel:hover{
    background:darkred;
}

.back{
    display:block;
    width:180px;
    margin:25px auto;
    text-align:center;
    text-decoration:none;
    background:#23407a;
    color:white;
    padding:12px;
    border-radius:8px;
}

.back:hover{
    background:#1b305d;
}

</style>

</head>

<body>

<h2>My Orders</h2>

<table>

<tr>
<th>Order ID</th>
<th>Total</th>
<th>Payment</th>
<th>Address</th>
<th>Phone</th>
<th>Order Date</th>
<th>Status</th>
<th>Action</th>
</tr>

<%
if(orders!=null && orders.size()>0){

for(Orders o:orders){
%>

<tr>

<td><%=o.getOrderId()%></td>

<td>₹ <%=o.getTotalAmount()%></td>

<td><%=o.getPaymentMethod()%></td>

<td><%=o.getAddress()%></td>

<td><%=o.getPhone()%></td>

<td><%=o.getOrderDate()%></td>

<td>
<%
String status = o.getStatus();

if("PENDING".equals(status)){
%>

<span class="pending">
🟡 PENDING
</span>

<%
}
else if("SHIPPED".equals(status)){
%>

<span class="shifted">
🚚 SHIPPED
</span>

<%
}
else if("DELIVERED".equals(status)){
%>

<span class="delivered">
✅ DELIVERED
</span>

<%
}
else if("CANCELLED".equals(status)){
%>

<span class="cancelled">
CANCELLED
</span>

<%
}
else{
%>

<span class="success">
<%=status%>
</span>

<%
}
%>

</td>

<td>

<%
if("PENDING".equals(status) || "CONFIRMED".equals(status)){
%>

<a href="cancelOrder?orderId=<%=o.getOrderId()%>"
onclick="return confirm('Do you want to cancel this order?')">

<button class="btn cancel">
Cancel
</button>

</a>

<%
}
else{
%>

--

<%
}
%>

</td>

</tr>

<%
}

}else{
%>

<tr>

<td colspan="8">
No Orders Found
</td>

</tr>

<%
}
%>

</table>

<a href="products" class="back">
← Continue Shopping
</a>

</body>
</html>