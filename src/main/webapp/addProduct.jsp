<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
if(session == null || session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
    return;
}
%>
	        }
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>

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
    border-bottom:3px solid #28a745;
    padding-bottom:10px;
}

label{
    font-weight:bold;
    color:#34495e;
    display:block;
    margin-bottom:5px;
}

input,
textarea{
    width:100%;
    padding:12px;
    margin-bottom:18px;
    border:1px solid #ccc;
    border-radius:8px;
    font-size:15px;
    transition:0.3s;
}

input:focus,
textarea:focus{
    outline:none;
    border-color:#28a745;
    box-shadow:0px 0px 5px rgba(40,167,69,0.4);
}

textarea{
    resize:none;
}

.btn{
    width:100%;
    padding:14px;
    background:#28a745;
    color:white;
    border:none;
    border-radius:8px;
    cursor:pointer;
    font-size:16px;
    font-weight:bold;
    transition:0.3s;
}

.btn:hover{
    background:#218838;
    transform:translateY(-2px);
}

</style>

</head>

<body>

<div class="container">

    <h2>Add Product</h2>

    <form action="AddProductServlet" method="post">

        <label>Product Name</label>
        <input type="text"
               name="productName"
               required>

        <label>Description</label>
        <textarea name="description"
                  rows="4"
                  required></textarea>

        <label>Price</label>
        <input type="number"
               step="0.01"
               name="price"
               required>

        <label>Category</label>
        <input type="text"
               name="category"
               required>

        <label>Quantity</label>
        <input type="number"
               name="quantity"
               required>

        <label>Image Name</label>
        <input type="text"
               name="image"
               placeholder="image.jpg"
               required>

        <button type="submit" class="btn">
            Add Product
        </button>

    </form>

</div>

</body>
</html>