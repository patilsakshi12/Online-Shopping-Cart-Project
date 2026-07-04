<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="com.shopping.model.Users"%>

<%
Users user =
(Users)request.getAttribute("user");
%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>

<style>

body{
font-family:Arial;
background:#eef3fb;
}

.container{

width:500px;
margin:50px auto;
background:white;
padding:30px;
border-radius:15px;
box-shadow:0px 5px 15px rgba(0,0,0,.2);

}

h2{

text-align:center;
color:#23407a;
margin-bottom:25px;

}

.row{

margin:15px 0;
font-size:18px;

}

.label{

font-weight:bold;
color:#23407a;

}

.btn{

display:block;
width:220px;
margin:25px auto;
text-align:center;
text-decoration:none;
padding:12px;
background:#23407a;
color:white;
border-radius:8px;

}

.btn:hover{

background:#1a2f5c;

}

</style>

</head>

<body>

<div class="container">

<h2>👤 My Profile</h2>

<div class="row">
<span class="label">Name :</span>
<%=user.getName()%>
</div>

<div class="row">
<span class="label">Email :</span>
<%=user.getEmail()%>
</div>



<div class="row">
<span class="label">Role :</span>
<%=user.getRole()%>
</div>

<a href="products" class="btn">
🛍 Back To Shopping
</a>

</div>

</body>
</html>
