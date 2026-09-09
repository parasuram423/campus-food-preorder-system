 package com.codegnan.app.servlet;

import java.io.IOException;

import com.codegnan.app.dao.PaymentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int orderId = Integer.parseInt(
                request.getParameter("orderId"));

        double amount = Double.parseDouble(
                request.getParameter("amount"));

        String paymentMethod =
                request.getParameter("paymentMethod");

        PaymentDAO paymentDAO = new PaymentDAO();

        boolean saved = paymentDAO.savePayment(
                orderId, amount, paymentMethod);

        response.setContentType("text/html");

        if (saved) {

            response.getWriter().println(
                    "<h2>Payment Successful!</h2>");

            response.getWriter().println(
                    "<p>Order ID: " + orderId + "</p>");

            response.getWriter().println(
                    "<p>Amount: " + amount + "</p>");

            response.getWriter().println(
                    "<p>Payment Method: "
                    + paymentMethod + "</p>");

            response.getWriter().println(
                    "<p>Status: SUCCESS</p>");

        } else {

            response.getWriter().println(
                    "<h2>Payment Failed</h2>");
        }
    }
}