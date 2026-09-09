 <!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Payment</title>
</head>

<body>

<h2>Payment</h2>

<form action="payment" method="post">

    <label>Order ID:</label>
    <input type="number" name="orderId" required>

    <br><br>

    <label>Amount:</label>
    <input type="number" name="amount" step="0.01" required>

    <br><br>

    <label>Payment Method:</label>

    <select name="paymentMethod" required>
        <option value="">Select</option>
        <option value="UPI">UPI</option>
        <option value="Cash">Cash</option>
        <option value="Card">Card</option>
    </select>

    <br><br>

    <input type="submit" value="Pay Now">

</form>

</body>

</html>