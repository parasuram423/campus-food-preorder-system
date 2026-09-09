 <!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Place Order</title>
</head>

<body>

<h2>Place Your Order</h2>

<form action="saveOrder" method="post">

    <input type="hidden"
           name="menuId"
           value="<%= request.getAttribute("menuId") %>">

    <label>Quantity:</label>

    <input type="number"
           name="quantity"
           min="1"
           value="1"
           required>

    <br><br>

    <input type="submit"
           value="Place Order">

</form>

</body>

</html>