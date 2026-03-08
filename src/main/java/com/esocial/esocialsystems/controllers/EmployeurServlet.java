package com.esocial.esocialsystems.controllers;

import com.esocial.esocialsystems.services.EmployeurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employeurs")
public class EmployeurServlet extends HttpServlet {
    private EmployeurService employeurService;

    @Override
    public void init() throws ServletException {
        employeurService = new EmployeurService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employeurs", employeurService.listerEmployeurs());
        request.getRequestDispatcher("/WEB-INF/views/employeurs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String raisonSociale = request.getParameter("raisonSociale");
        String secteurActivite = request.getParameter("secteurActivite");

        employeurService.creerEmployeur(raisonSociale, secteurActivite);
        response.sendRedirect(request.getContextPath() + "/employeurs");
    }
}