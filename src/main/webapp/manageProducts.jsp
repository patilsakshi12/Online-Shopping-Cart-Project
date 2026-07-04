<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*,com.shopping.model.Products"%>

<%
if(session == null || session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
    return;
}
%>
<%
List<Products> list =
(List<Products>)request.getAttribute("products");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Products</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, sans-serif;
}

body{
    background:#eef2f7;
}

h2{
    text-align:center;
    margin-top:20px;
    color:#333;
}

.add-btn{
    background:#28a745;
    color:white;
    padding:10px 20px;
    border:none;
    border-radius:20px;
    cursor:pointer;
    font-size:15px;
    margin-top:20px;
}

.add-btn:hover{
    background:#218838;
}

table{
    width:90%;
    margin:30px auto;
    border-collapse:collapse;
    background:white;
    box-shadow:0px 0px 10px lightgray;
}

th{
    background:#343a40;
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

img{
    border-radius:5px;
}

.edit-btn{
    text-decoration:none;
    background:#007bff;
    color:white;
    padding:6px 12px;
    border-radius:5px;
    margin-right:5px;
}

.edit-btn:hover{
    background:#0056b3;
}

.delete-btn{
    text-decoration:none;
    background:#dc3545;
    color:white;
    padding:6px 12px;
    border-radius:5px;
}

.delete-btn:hover{
    background:#c82333;
}

</style>

</head>
<body>

<h2>Manage Products</h2>

<center>
<a href="addProduct.jsp">
    <button class="add-btn">Add Product</button>
</a>
</center>

<table>

<tr>
<th>ID</th>
<th>Image</th>
<th>Name</th>
<th>Price</th>
<th>Category</th>
<th>Quantity</th>
<th>Actions</th>
</tr>

<%
if(list != null){
    for(Products p:list){
%>

<tr>

<td><%= p.getProductId() %></td>

<td>
<img src="images/<%= p.getImage() %>"
     width="80"
     height="80">
</td>

<td><%= p.getProductName() %></td>

<td>
    &#8377; <%= String.format("%.2f", p.getPrice()) %>
</td>

<td><%= p.getCategory() %></td>

<td><%= p.getQuantity() %></td>

<td>

<a class="edit-btn"
   href="EditProductServlet?id=<%=p.getProductId()%>">
   Edit
</a>

<a class="delete-btn"
   href="DeleteProductServlet?id=<%=p.getProductId()%>"
   onclick="return confirm('Are you sure you want to delete this product?')">
   Delete
</a>

</td>

</tr>

<%
    }
}
%>

</table>

</body>
</html>