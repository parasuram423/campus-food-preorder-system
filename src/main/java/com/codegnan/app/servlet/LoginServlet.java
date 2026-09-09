 package com.codegnan.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.codegnan.app.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");

        String password = request.getParameter("password");

        StudentDAO studentDAO = new StudentDAO();

        boolean valid =
                studentDAO.validateStudent(email, password);

        if (valid) {

            response.sendRedirect("menu");

        } else {

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.println("<h2>Invalid Email or Password</h2>");
        }
    }
}