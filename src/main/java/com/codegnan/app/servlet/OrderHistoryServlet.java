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

@WebServlet("/orderHistory")
public class OrderHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM orders WHERE student_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 1);

            ResultSet rs = ps.executeQuery();

            request.setAttribute("orders", rs);

            request.getRequestDispatcher("orderHistory.jsp")
                   .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}