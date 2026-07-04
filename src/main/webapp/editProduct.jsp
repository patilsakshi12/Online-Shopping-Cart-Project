<%@ page import="com.shopping.model.Products" %>

<%

Products p = (Products)request.getAttribute("product");

if(p == null){
out.println("<h2>Product is null</h2>");
return;
}
%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

body{
    background:linear-gradient(135deg,#dbeafe,#f0f9ff);
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.container{
    width:550px;
    background:white;
    padding:35px;
    border-radius:15px;
    box-shadow:0px 5px 20px rgba(0,0,0,0.15);
}

h2{
    text-align:center;
    color:#2c3e50;
    margin-bottom:25px;
    border-bottom:3px solid #007bff;
    padding-bottom:10px;
}

label{
    font-weight:bold;
    color:#34495e;
    display:block;
    margin-bottom:5px;
}

input{
    width:100%;
    padding:12px;
    margin-bottom:18px;
    border:1px solid #ccc;
    border-radius:8px;
    font-size:15px;
    transition:0.3s;
}

input:focus{
    outline:none;
    border-color:#007bff;
    box-shadow:0px 0px 5px rgba(0,123,255,0.4);
}

.btn{
    width:100%;
    padding:14px;
    background:#007bff;
    color:white;
    border:none;
    border-radius:8px;
    cursor:pointer;
    font-size:16px;
    font-weight:bold;
    transition:0.3s;
}

.btn:hover{
    background:#0056b3;
    transform:translateY(-2px);
}

</style>

</head>
<body>

<div class="container">

<h2>Edit Product</h2>

<form action="UpdateProductServlet" method="post">

<input type="hidden"
    name="productId"
    value="<%=p.getProductId()%>">

<label>Product Name</label> <input type="text"
    name="productName"
    value="<%=p.getProductName()%>">

<label>Description</label> <input type="text"
    name="description"
    value="<%=p.getDescription()%>">

<label>Category</label> <input type="text"
    name="category"
    value="<%=p.getCategory()%>">

<label>Price</label> <input type="text"
    name="price"
    value="<%=p.getPrice()%>">

<label>Quantity</label> <input type="text"
    name="quantity"
    value="<%=p.getQuantity()%>">

<label>Image</label> <input type="text"
    name="image"
    value="<%=p.getImage()%>">

<input type="submit"
    value="Update Product"
    class="btn">

</form>

</div>

</body>
</html>
