<%@ page import="java.sql.ResultSet" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Order Status</title>
</head>

<body>

<h2>Order Status</h2>

<table border="1">

    <tr>
        <th>Order ID</th>
        <th>Quantity</th>
        <th>Total Price</th>
        <th>Status</th>
    </tr>

<%
    ResultSet orders =
        (ResultSet) request.getAttribute("orders");

    while (orders.next()) {
%>

    <tr>
        <td><%= orders.getInt("order_id") %></td>
        <td><%= orders.getInt("quantity") %></td>
        <td><%= orders.getDouble("total_price") %></td>
        <td><%= orders.getString("status") %></td>
    </tr>

<%
    }
%>

</table>

<br>

<a href="menu">Back to Menu</a>

</body>

</html>