package com.esocial.esocialsystems.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if ("admin".equals(user) && "admin".equals(pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("utilisateurConnecte", user);

            response.sendRedirect(request.getContextPath() + "/employeurs");
        } else {
            request.setAttribute("erreur", "Identifiants incorrects. Utilisez admin / admin.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}