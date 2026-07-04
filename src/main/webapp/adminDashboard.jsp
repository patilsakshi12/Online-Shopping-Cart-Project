<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
if(session == null || session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Inter',sans-serif;
}

body{
    background:linear-gradient(135deg,#0f172a,#1e293b,#334155);
    color:white;
}

/* ================= HEADER ================= */

.header{
    position:fixed;
    top:0;
    left:0;
    width:100%;
    height:70px;
    background:linear-gradient(90deg,#2563eb,#1d4ed8,#1e40af);
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:0 35px;
    z-index:1000;
    box-shadow:0 6px 18px rgba(37,99,235,.35);
}

.logo{
    font-size:23px;
    font-weight:700;
    letter-spacing:.5px;
}

.admin-profile{
    background:white;
    color:#2563eb;
    padding:10px 18px;
    border-radius:30px;
    font-weight:600;
    font-size:15px;
    box-shadow:0 5px 15px rgba(0,0,0,.2);
}

/* ================= SIDEBAR ================= */

.sidebar{
    position:fixed;
    top:70px;
    left:0;
    width:250px;
    height:100%;
    background:linear-gradient(180deg,#1e293b,#111827);
    padding-top:25px;
    box-shadow:4px 0 15px rgba(0,0,0,.25);
}

.sidebar a{

    display:block;
    margin:10px 15px;
    padding:15px 20px;
    text-decoration:none;
    color:#dbeafe;
    font-size:16px;
    font-weight:500;
    border-radius:12px;
    transition:.35s;
}

.sidebar a:hover{

    background:#3b82f6;
    color:white;
    transform:translateX(8px);
    box-shadow:0 8px 20px rgba(59,130,246,.35);

}

/* ================= MAIN ================= */

.main{

    margin-left:250px;
    margin-top:70px;
    padding:35px;

}

/* ================= WELCOME ================= */

.welcome{

    background:linear-gradient(135deg,#334155,#1e293b);
    border-left:6px solid #3b82f6;
    padding:30px;
    border-radius:18px;
    box-shadow:0 10px 25px rgba(0,0,0,.25);
    margin-bottom:35px;

}

.welcome h2{

    font-size:30px;
    margin-bottom:10px;

}

.welcome p{

    color:#cbd5e1;
    font-size:17px;

}

/* ================= GRID ================= */

.grid{

    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(220px,1fr));
    gap:28px;

}

/* ================= CARD ================= */

.card{

    height:180px;
    border-radius:20px;
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    text-align:center;
    cursor:pointer;
    transition:.35s;
    color:white;
    box-shadow:0 10px 25px rgba(0,0,0,.25);

}

.card:hover{

    transform:translateY(-10px) scale(1.04);
    box-shadow:0 18px 35px rgba(0,0,0,.35);

}

.icon{

    font-size:48px;
    margin-bottom:15px;

}

.title{

    font-size:20px;
    font-weight:700;
    margin-bottom:8px;

}

.desc{

    font-size:14px;
    opacity:.95;
    padding:0 15px;

}

/* ================= CARD COLORS ================= */

.product{

    background:linear-gradient(135deg,#60a5fa,#2563eb);

}

.users{

    background:linear-gradient(135deg,#34d399,#059669);

}

.orders{

    background:linear-gradient(135deg,#fbbf24,#d97706);

}

.logout{

    background:linear-gradient(135deg,#fb7185,#e11d48);

}

a{

    text-decoration:none;

}

</style>

</head>
<body>

<!-- ================= HEADER ================= -->

<div class="header">

    <div class="logo">
        🛒 Online Shopping Admin
    </div>

    <div class="admin-profile">
        👤 Welcome, Admin
    </div>

</div>

<!-- ================= SIDEBAR ================= -->

<div class="sidebar">

    <a href="viewProductsAdmin">
        📦 Manage Products
    </a>

    <a href="viewUsers">
        👥 View Users
    </a>

    <a href="viewOrders">
        🛒 View Orders
    </a>

    <a href="logout">
        🚪 Logout
    </a>

</div>

<!-- ================= MAIN ================= -->

<div class="main">

    <!-- Welcome -->

    <div class="welcome">

        <h2>Welcome Back, Admin 👋</h2>

        <p>
            Manage your products, users and customer orders from one
            professional dashboard.
        </p>

    </div>

    <!-- Dashboard Cards -->

    <div class="grid">

        <!-- Product -->

        <a href="viewProductsAdmin">

            <div class="card product">

                <div class="icon">📦</div>

                <div class="title">
                    Manage Products
                </div>

                <div class="desc">
                    Add, update and delete products.
                </div>

            </div>

        </a>

        <!-- Users -->

        <a href="viewUsers">

            <div class="card users">

                <div class="icon">👥</div>

                <div class="title">
                    View Users
                </div>

                <div class="desc">
                    View registered customers.
                </div>

            </div>

        </a>

        <!-- Orders -->

        <a href="viewOrders">

            <div class="card orders">

                <div class="icon">🛍️</div>

                <div class="title">
                    View Orders
                </div>

                <div class="desc">
                    Track and manage customer orders.
                </div>

            </div>

        </a>

        <!-- Logout -->

        <a href="logout">

            <div class="card logout">

                <div class="icon">🚪</div>

                <div class="title">
                    Logout
                </div>

                <div class="desc">
                    Securely sign out from dashboard.
                </div>

            </div>

        </a>

    </div>

</div>

</body>
</html>