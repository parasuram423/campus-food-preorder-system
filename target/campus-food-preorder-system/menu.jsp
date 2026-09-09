 <%@ page import="java.util.List" %>
<%@ page import="com.codegnan.app.model.Menu" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Campus Food Menu</title>
</head>

<body>

<h2>Campus Food Menu</h2>

<table border="1">

    <tr>
        <th>ID</th>
        <th>Item Name</th>
        <th>Price</th>
        <th>Action</th>
    </tr>

<%
    List<Menu> menuList =
        (List<Menu>) request.getAttribute("menuList");

    for (Menu menu : menuList) {
%>

    <tr>

        <td>
            <%= menu.getId() %>
        </td>

        <td>
            <%= menu.getItemName() %>
        </td>

        <td>
            <%= String.format("%.0f", menu.getPrice()) %>
        </td>

        <td>

            <form action="order" method="post">

                <input type="hidden"
                       name="menuId"
                       value="<%= menu.getId() %>">

                <input type="submit"
                       value="Order">

            </form>

        </td>

    </tr>

<%
    }
%>

</table>

<br>

<a href="index.html">Back to Home</a>

</body>

</html>