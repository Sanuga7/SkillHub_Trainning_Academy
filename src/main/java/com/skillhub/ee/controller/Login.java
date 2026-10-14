package com.skillhub.ee.controller;

import com.skillhub.ee.model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String pwd = req.getParameter("password");

        ServletContext context = getServletContext();
        Map<String, User> users = (Map<String, User>) context.getAttribute("users");

        User user = users.get(username);
        if(user != null && user.getPassword().equals(pwd)){
            HttpSession session = req.getSession();
            session.setAttribute("loggedUser", user);

            switch (user.getRole()) {
                case "ADMIN" -> resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
                case "TRAINER" -> resp.sendRedirect(req.getContextPath() + "/trainer/dashboard");
                case "USER" -> resp.sendRedirect(req.getContextPath() + "/dashboard");
                default -> {
                    req.setAttribute("error", "Something Went Wrong");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
            }
        }else{
            req.setAttribute("error", "Invalid Credentials");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
