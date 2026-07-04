<%@ page import="java.util.*,com.shopping.model.Orders"%>
<%
if(session == null || session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
    return;
}
%>
<%
List<Orders> orders =
(List<Orders>)request.getAttribute("orders");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Orders</title>

<style>

body{
    font-family:Arial;
    background:#eef2f7;
}

h2{
    text-align:center;
    margin:20px;
}

table{
    width:95%;
    margin:auto;
    border-collapse:collapse;
    background:white;
    box-shadow:0px 0px 10px lightgray;
}

th{
    background:#343a40;
    color:white;
    padding:10px;
}

td{
    text-align:center;
    padding:10px;
    border-bottom:1px solid #ddd;
}

tr:hover{
    background:#f5f5f5;
}

.success{
    color:green;
    font-weight:bold;
}

</style>

</head>
<body>

<h2>All Orders</h2>

<table>

<tr>
<th>Order ID</th>
<th>User ID</th>
<th>Total Amount</th>
<th>Payment</th>
<th>Address</th>
<th>Phone</th>
<th>Order Date</th>
<th>Status</th>
</tr>

<%
for(Orders o : orders){
%>

<tr>

<td><%=o.getOrderId()%></td>

<td><%=o.getUserId()%></td>

<td>&#8377; <%=o.getTotalAmount()%></td>

<td><%=o.getPaymentMethod()%></td>

<td><%=o.getAddress()%></td>

<td><%=o.getPhone()%></td>

<td><%=o.getOrderDate()%></td>

<td>

<form action="UpdateOrderStatusServlet" method="post">

<input
type="hidden"
name="orderId"
value="<%=o.getOrderId()%>">

<select name="status">

<option value="PENDING"
<%=o.getStatus().equals("PENDING")?"selected":""%>>
PENDING
</option>

<option value="CONFIRMED"
<%=o.getStatus().equals("CONFIRMED")?"selected":""%>>
CONFIRMED
</option>

<option value="SHIPPED"
<%=o.getStatus().equals("SHIPPED")?"selected":""%>>
SHIPPED
</option>

<option value="OUT FOR DELIVERY"
<%=o.getStatus().equals("OUT FOR DELIVERY")?"selected":""%>>
OUT FOR DELIVERY
</option>

<option value="DELIVERED"
<%=o.getStatus().equals("DELIVERED")?"selected":""%>>
DELIVERED
</option>

<option value="CANCELLED"
<%=o.getStatus().equals("CANCELLED")?"selected":""%>>
CANCELLED
</option>

</select>

<input
type="submit"
value="Update">

</form>

</td>

</tr>

<%
}
%>

</table>

</body>
</html>