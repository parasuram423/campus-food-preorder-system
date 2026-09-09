 package com.codegnan.app.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.codegnan.app.dao.OrderItemDAO;
import com.codegnan.app.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saveOrder")
public class SaveOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        int menuId =
                Integer.parseInt(request.getParameter("menuId"));

        int quantity =
                Integer.parseInt(request.getParameter("quantity"));

        try {

            Connection con = DBConnection.getConnection();

            // Get menu price
            String priceSql =
                    "SELECT price FROM menu WHERE id = ?";

            PreparedStatement pricePs =
                    con.prepareStatement(priceSql);

            pricePs.setInt(1, menuId);

            ResultSet rs =
                    pricePs.executeQuery();

            if (rs.next()) {

                double price =
                        rs.getDouble("price");

                double totalPrice =
                        price * quantity;

                // Save order
                String orderSql =
                        "INSERT INTO orders "
                        + "(student_id, menu_id, quantity, total_price) "
                        + "VALUES (?, ?, ?, ?)";

                PreparedStatement orderPs =
                        con.prepareStatement(
                                orderSql,
                                PreparedStatement.RETURN_GENERATED_KEYS);

                orderPs.setInt(1, 1);
                orderPs.setInt(2, menuId);
                orderPs.setInt(3, quantity);
                orderPs.setDouble(4, totalPrice);

                orderPs.executeUpdate();

                // Get generated order ID
                ResultSet generatedKeys =
                        orderPs.getGeneratedKeys();

                if (generatedKeys.next()) {

                    int orderId =
                            generatedKeys.getInt(1);

                    // Save order item
                    OrderItemDAO orderItemDAO =
                            new OrderItemDAO();

                    orderItemDAO.saveOrderItem(
                            orderId,
                            menuId,
                            quantity,
                            price,
                            totalPrice);

                    response.setContentType("text/html");

                    response.getWriter().println(
                            "<h2>Order Placed Successfully!</h2>");

                    response.getWriter().println(
                            "<p>Order ID: "
                            + orderId + "</p>");

                    response.getWriter().println(
                            "<p>Quantity: "
                            + quantity + "</p>");

                    response.getWriter().println(
                            "<p>Total Price: "
                            + String.format("%.0f", totalPrice)
                            + "</p>");

                    response.getWriter().println(
                            "<br><a href='menu'>Back to Menu</a>");
                }

                generatedKeys.close();
                orderPs.close();
            }

            rs.close();
            pricePs.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

            response.setContentType("text/html");

            response.getWriter().println(
                    "<h2>Order Failed</h2>");

            response.getWriter().println(
                    "<p>" + e.getMessage() + "</p>");
        }
    }
}