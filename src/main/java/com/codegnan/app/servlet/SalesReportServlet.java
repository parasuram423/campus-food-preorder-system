 package com.codegnan.app.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.codegnan.app.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/salesReport")
public class SalesReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) AS total_orders, "
                       + "COALESCE(SUM(total_price), 0) AS total_sales "
                       + "FROM orders "
                       + "WHERE order_date = CURRENT_DATE";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int totalOrders =
                        rs.getInt("total_orders");

                double totalSales =
                        rs.getDouble("total_sales");

                request.setAttribute(
                        "totalOrders", totalOrders);

                request.setAttribute(
                        "totalSales", totalSales);
            }

            rs.close();
            ps.close();
            con.close();

            request.getRequestDispatcher(
                    "salesReport.jsp")
                   .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

            response.setContentType("text/html");

            response.getWriter().println(
                    "<h2>Sales Report Failed</h2>");

            response.getWriter().println(
                    "<p>" + e.getMessage() + "</p>");
        }
    }
}