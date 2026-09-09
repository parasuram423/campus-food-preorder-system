 package com.codegnan.app.servlet;

import java.io.IOException;
import java.util.List;

import com.codegnan.app.dao.MenuDAO;
import com.codegnan.app.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        MenuDAO menuDAO = new MenuDAO();

        List<Menu> menuList = menuDAO.getAllMenuItems();

        request.setAttribute("menuList", menuList);

        request.getRequestDispatcher("menu.jsp")
               .forward(request, response);
    }
}