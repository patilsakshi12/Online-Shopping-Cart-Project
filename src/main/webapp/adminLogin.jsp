<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>

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

    background: linear-gradient(135deg,
        #fff8e7,
        #ffe7c7,
        #fff3d6
    );
}

/* CARD */
.card{
    width:420px;
    background:#ffffff;
    padding:45px 35px;
    border-radius:18px;
    text-align:center;

    box-shadow:0 15px 40px rgba(0,0,0,0.12);

    animation: floatBox 5s ease-in-out infinite;
}

@keyframes floatBox{
    0%{transform:translateY(0px);}
    50%{transform:translateY(-10px);}
    100%{transform:translateY(0px);}
}

h1{
    color:#333;
    margin-bottom:5px;
}

/* UNDERLINE */
.underline{
    width:220px;
    height:6px;
    margin:12px auto 25px;
    border-radius:50px;

    background:linear-gradient(
        90deg,
        #f7b733,
        #fc4a1a
    );

    box-shadow:0 0 18px rgba(247,183,51,0.5);
}

/* LABEL */
.label{
    text-align:left;
    margin-top:10px;
    font-size:14px;
    font-weight:600;
    color:#333;
}

/* INPUT */
input{
    width:100%;
    padding:13px;
    margin-top:5px;
    margin-bottom:12px;

    border:1px solid #ddd;
    border-radius:10px;

    outline:none;
    transition:0.3s;
}

input:focus{
    border-color:#f7b733;
    box-shadow:0 0 10px rgba(247,183,51,0.35);
}

/* BUTTON */
.btn{
    width:100%;
    padding:13px;
    margin-top:10px;

    border:none;
    border-radius:10px;

    background:linear-gradient(
        90deg,
        #f7b733,
        #fc4a1a
    );

    color:white;
    font-size:16px;
    font-weight:bold;

    cursor:pointer;
    transition:0.3s;
}

.btn:hover{
    transform:scale(1.05);

    box-shadow:0 10px 20px rgba(252,74,26,0.35);
}

/* TEXT */
p{
    margin-top:18px;
    font-size:14px;
    color:#555;
}

a{
    color:#fc4a1a;
    font-weight:bold;
    text-decoration:none;
}

a:hover{
    text-decoration:underline;
}


</style>

</head>

<body>

<div class="card">

    

    <h1>Admin Login</h1>

    <div class="underline"></div>

    <form action="login" method="post">

        <div class="label">Admin Email</div>
        <input type="email" name="email" required>

        <div class="label">Password</div>
        <input type="password" name="password" required>

        <button type="submit" class="btn">
            Login
        </button>

    </form>

</div>

</body>
</html>