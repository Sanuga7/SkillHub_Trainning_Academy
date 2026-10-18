package com.skillhub.ee.controller;

import com.skillhub.ee.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if(session == null || session.getAttribute("loggedUser") == null){
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
            return;
        }

        User user = (User) session.getAttribute("loggedUser");

        if(user.getRole().equals("ADMIN")) {
            req.getRequestDispatcher("/admin-dashboard.jsp").forward(req, resp);
        } else if (user.getRole().equals("TRAINER")) {
            req.getRequestDispatcher("/trainer-dashboard.jsp").forward(req, resp);
        } else if (user.getRole().equals("USER")) {
            req.getRequestDispatcher("/student-dashboard.jsp").forward(req, resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }

    }
}
