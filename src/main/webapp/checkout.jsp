<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.util.*,com.shopping.model.CartItem"%>

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
<title>Checkout</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    font-family:Arial, sans-serif;
    background:linear-gradient(to right,#eef3fb,#dfefff);
    padding:30px;
}

.container{
    width:850px;
    margin:auto;
    background:white;
    padding:30px;
    border-radius:15px;
    box-shadow:0 5px 20px rgba(0,0,0,0.15);
}

h2{
    text-align:center;
    color:#23407a;
    margin-bottom:25px;
}

h3{
    color:#23407a;
    margin-top:20px;
    margin-bottom:10px;
    border-left:5px solid #28a745;
    padding-left:10px;
}

input,
textarea{
    width:100%;
    padding:10px;
    margin-top:5px;
    margin-bottom:15px;
    border:1px solid #ccc;
    border-radius:5px;
    font-size:14px;
}

input:focus,
textarea:focus{
    outline:none;
    border-color:#28a745;
}

textarea{
    resize:none;
    height:80px;
}

table{
    width:100%;
    border-collapse:collapse;
    margin-top:15px;
}

th{
    background:#23407a;
    color:white;
}

th,td{
    border:1px solid #ddd;
    padding:12px;
    text-align:center;
}

tr:nth-child(even){
    background:#f8f9fa;
}

.payment-section{
    margin-top:20px;
}

input[type="radio"]{
    width:auto;
    margin-right:8px;
}

#upiBox,
#cardBox{
    display:none;
    margin-top:15px;
    background:#f8f9fa;
    padding:15px;
    border-radius:8px;
    border:1px solid #ddd;
}

.btn{
    width:100%;
    padding:14px;
    background:#28a745;
    color:white;
    border:none;
    font-size:17px;
    font-weight:bold;
    border-radius:8px;
    cursor:pointer;
    margin-top:20px;
}

.btn:hover{
    background:#218838;
}

.total-row{
    background:#e8f5e9;
    font-weight:bold;
}

</style>

</head>

<body>

<div class="container">

<h2>🛒 Checkout Page</h2>

<form action="placeOrder" method="post">

<h3>Shipping Details</h3>

Full Name:
<input type="text" name="name" required>

Email:
<input type="email" name="email" required>

Phone:
<input type="text" name="phone" required>

Address:
<textarea name="address" required></textarea>

<h3>Order Summary</h3>

<table>

<tr>
<th>Product</th>
<th>Price</th>
<th>Qty</th>
<th>Total</th>
</tr>

<%
List<CartItem> list =
(List<CartItem>)request.getAttribute("cartList");

double grandTotal = 0;

if(list != null){

for(CartItem item : list){

double total =
item.getPrice() * item.getQuantity();

grandTotal += total;
%>

<tr>
<td><%= item.getProductName() %></td>
<td>₹<%= item.getPrice() %></td>
<td><%= item.getQuantity() %></td>
<td>₹<%= total %></td>
</tr>

<%
}
}
%>

<tr class="total-row">
<td colspan="3">Total Amount</td>
<td>₹<%= grandTotal %></td>
</tr>

</table>

<input type="hidden"
name="total"
value="<%= grandTotal %>">

<%
Boolean buyNow = (Boolean)request.getAttribute("buyNow");

if(buyNow != null && buyNow){
%>

<input
type="hidden"
name="buyNow"
value="true">

<input
type="hidden"
name="productId"
value="<%= list.get(0).getProductId() %>">

<%
}
%>

<div class="payment-section">

<h3>Payment Method</h3>

<label>
<input type="radio"
name="payment"
value="COD"
onclick="showPayment()">
Cash On Delivery
</label>

<br><br>

<label>
<input type="radio"
name="payment"
value="UPI"
onclick="showPayment()">
UPI
</label>

<br><br>

<label>
<input type="radio"
name="payment"
value="CARD"
onclick="showPayment()">
Credit / Debit Card
</label>

<div id="upiBox">

UPI ID:
<input type="text"
name="upiId"
placeholder="example@upi">

</div>

<div id="cardBox">

Card Number:
<input type="text"
name="cardNumber"
placeholder="1234 5678 9012 3456">

Expiry Date:
<input type="text"
name="expiry"
placeholder="MM/YY">

CVV:
<input type="password"
name="cvv"
placeholder="123">

</div>

</div>

<button class="btn" type="submit">
Place Order
</button>

</form>

</div>

<script>

function showPayment(){

let payment =
document.querySelector(
'input[name="payment"]:checked'
).value;

let upiBox =
document.getElementById("upiBox");

let cardBox =
document.getElementById("cardBox");

if(payment === "UPI"){

    upiBox.style.display = "block";
    cardBox.style.display = "none";

}
else if(payment === "CARD"){

    upiBox.style.display = "none";
    cardBox.style.display = "block";

}
else{

    upiBox.style.display = "none";
    cardBox.style.display = "none";

}

}

</script>

</body>
</html>