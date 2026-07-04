<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Empty</title>

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
    background:linear-gradient(135deg,#74ebd5,#ACB6E5);

}

.container{

    width:520px;
    background:white;
    padding:40px;
    border-radius:20px;
    text-align:center;
    box-shadow:0 15px 35px rgba(0,0,0,.2);

}

.icon{

    font-size:90px;
    margin-bottom:15px;

}

h1{

    color:#23407a;
    margin-bottom:15px;

}

p{

    color:#555;
    font-size:18px;
    line-height:28px;
    margin-bottom:30px;

}

.btn{

    display:inline-block;
    padding:14px 28px;
    text-decoration:none;
    border-radius:30px;
    color:white;
    font-size:16px;
    font-weight:bold;
    transition:.3s;

}

.btn:hover{

    transform:scale(1.05);

}

.shop{

    background:#28a745;

}

.shop:hover{

    background:#218838;

}

.home{

    background:#23407a;
    margin-left:10px;

}

.home:hover{

    background:#1b305d;

}

</style>

</head>

<body>

<div class="container">

    <div class="icon">
        🛒
    </div>

    <h1>Your Cart is Empty</h1>

    <p>
        Looks like you haven't added any products yet.<br>
        Explore our latest collection and start shopping.
    </p>

    <a href="products" class="btn shop">
        Continue Shopping
    </a>

   

</div>

</body>
</html>