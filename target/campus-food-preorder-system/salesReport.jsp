 <!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Daily Sales Report</title>
</head>

<body>

<h2>Daily Sales Report</h2>

<table border="1">

    <tr>
        <th>Total Orders</th>
        <th>Total Sales</th>
    </tr>

    <tr>
        <td>
            <%= request.getAttribute("totalOrders") %>
        </td>

        <td>
            <%= request.getAttribute("totalSales") %>
        </td>
    </tr>

</table>

<br>

<a href="menu">Back to Menu</a>

</body>

</html>