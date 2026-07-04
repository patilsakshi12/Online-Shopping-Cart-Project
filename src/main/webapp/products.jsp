<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.util.*,com.shopping.model.Products,com.shopping.model.Users"%>

<%
if(session==null || session.getAttribute("user")==null){
    response.sendRedirect("login.jsp");
    return;
}

Users user=(Users)session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Shopping</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:'Segoe UI',sans-serif;
}

body{
background:#f3f7ff;
}

/*================ HEADER =================*/

.header{

display:flex;
justify-content:space-between;
align-items:center;

padding:18px 40px;

background:linear-gradient(90deg,#1e3c72,#2a5298);

box-shadow:0 4px 12px rgba(0,0,0,.2);

}

.logo{

font-size:30px;
font-weight:bold;
color:white;

}

.right{

display:flex;
align-items:center;
gap:25px;

}

.profile{

background:white;
padding:8px 18px;
border-radius:25px;
font-weight:bold;
color:#23407a;

}

.menu a{

text-decoration:none;

color:white;

margin-left:18px;

font-weight:bold;

padding:10px 15px;

border-radius:8px;

transition:.3s;

}

.menu a:hover{

background:white;

color:#23407a;

}

/*================ SEARCH =================*/

.search-box{

text-align:center;

margin:35px;

}

.search-box input{

width:350px;

padding:12px;

border-radius:25px;

border:1px solid lightgray;

outline:none;

font-size:15px;

}

.search-box button{

padding:12px 20px;

border:none;

background:#28a745;

color:white;

border-radius:25px;

cursor:pointer;

font-size:15px;

font-weight:bold;

}

.search-box button:hover{

background:#218838;

}

/*TITLE */

h2{

text-align:center;

margin-bottom:30px;

color:#23407a;

font-size:32px;

}

/*PRODUCT */

.product-container{

display:flex;

flex-wrap:wrap;

justify-content:center;

gap:25px;

padding:20px;

}

.product-box{

width:250px;

background:white;

border-radius:15px;

padding:15px;

box-shadow:0 8px 18px rgba(0,0,0,.15);

transition:.3s;

}

.product-box:hover{

transform:translateY(-8px);

}

.product-box img{

width:100%;

height:180px;

object-fit:contain;

}

.product-name{

font-size:20px;

font-weight:bold;

color:#23407a;

margin-top:10px;

}

.product-desc{

font-size:14px;

color:#666;

margin:10px 0;

height:45px;

}

.price{

font-size:23px;

font-weight:bold;

color:#28a745;

margin-bottom:15px;

}

.cart-btn{

width:100%;

padding:12px;

border:none;

border-radius:10px;

background:#00b894;

color:white;

font-size:16px;

font-weight:bold;

cursor:pointer;

transition:.3s;

}

.cart-btn:hover{

background:#019875;

}
.buy-btn{

width:100%;

padding:12px;

margin-top:10px;

border:none;

border-radius:25px;

background:#ff9800;

color:white;

font-size:16px;

font-weight:bold;

cursor:pointer;

transition:.3s;

}

.buy-btn:hover{

background:#f57c00;

transform:scale(1.03);

}


</style>

</head>

<body>

<div class="header">

<div class="logo">

 Online Shop

</div>

<div class="right">

<div class="profile">

👤 Welcome,
<b><%=user.getName()%></b>

</div>

<div class="menu">

<a href="products">🏠 Home</a>

<a href="viewCart">🛒 Cart</a>

<a href="myOrders">📦 My Orders</a>
<a href="profile">👤 Profile</a>

<a href="logout">🚪 Logout</a>

</div>

</div>

</div>

<div class="search-box">

<form action="SearchProductServlet" method="get">

<input
type="text"
name="keyword"
placeholder="Search Products...">

<button type="submit">

🔍 Search

</button>

</form>

</div>

<h2>Our Products</h2>

<div class="product-container">

<%

List<Products> list=(List<Products>)request.getAttribute("products");

if(list!=null){

for(Products p:list){

%>
<div class="product-box">

    <img src="images/<%=p.getImage()%>" alt="Product Image">

    <div class="product-name">
        <%=p.getProductName()%>
    </div>

    <div class="product-desc">
        <%=p.getDescription()%>
    </div>

    <div class="price">
        ₹ <%=p.getPrice()%>
    </div>

    <form action="cartServlet" method="get">

        <input
        type="hidden"
        name="productId"
        value="<%=p.getProductId()%>">

        <button
        type="submit"
        class="cart-btn">

        Add To Cart

        </button>

    </form>
    <form action="buyNow" method="get">

<input
type="hidden"
name="productId"
value="<%=p.getProductId()%>">

<button
type="submit"
class="buy-btn">
 Buy Now

</button>

</form>

</div>

<%
    }
}
else{
%>

<h2>No Products Available</h2>

<%
}
%>

</div>
<%
String msg = (String)request.getAttribute("msg");

if("added".equals(msg)){
%>

<script>
alert(" Product Added To Cart Successfully!");
</script>

<%
}
%>

</body>
</html>