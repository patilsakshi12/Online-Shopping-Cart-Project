<%@ page import="java.util.*,com.shopping.model.Users" %>
<%
if(session == null || session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
    return;
}
%>
<%
List<Users> users =
(List<Users>)request.getAttribute("users");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Users</title>

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
    width:90%;
    margin:auto;
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

</style>

</head>
<body>

<h2>Registered Users</h2>

<table>

<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Role</th>
</tr>

<%
for(Users u : users){
%>

<tr>

<td><%=u.getUserId()%></td>
<td><%=u.getName()%></td>
<td><%=u.getEmail()%></td>
<td><%=u.getPassword()%></td>
<td><%=u.getRole()%></td>

</tr>

<%
}
%>

</table>

</body>
</html>