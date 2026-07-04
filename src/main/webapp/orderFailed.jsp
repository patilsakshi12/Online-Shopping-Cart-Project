<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Failed</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg,#ff9a9e,#fad0c4);
}

.container{

    width:500px;
    background:white;
    border-radius:18px;
    padding:40px;
    text-align:center;
    box-shadow:0 15px 35px rgba(0,0,0,.25);

}

.icon{

    font-size:80px;
    margin-bottom:15px;

}

h1{

    color:#dc3545;
    margin-bottom:15px;

}

p{

    font-size:18px;
    color:#555;
    margin-bottom:30px;
    line-height:28px;

}

.btn{

    display:inline-block;
    padding:13px 28px;
    margin:8px;
    text-decoration:none;
    border-radius:30px;
    color:white;
    font-size:16px;
    font-weight:bold;
    transition:.3s;

}

.shop{

    background:#007bff;

}

.shop:hover{

    background:#0056b3;

}

.cart{

    background:#28a745;

}

.cart:hover{

    background:#1e7e34;

}

</style>

</head>

<body>

<div class="container">

<div class="icon">
❌
</div>

<h1>Order Failed</h1>

<p>

<%
String msg=(String)request.getAttribute("msg");

if(msg==null){
    msg="Sorry! Your order could not be placed. Please try again.";
}
%>

<%=msg%>

</p>

<a href="products" class="btn shop">
Continue Shopping
</a>

<a href="viewCart" class="btn cart">
Go To Cart
</a>

</div>

</body>
</html>