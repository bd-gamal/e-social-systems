package com.esocial.esocialsystems.servlets;

import com.esocial.esocialsystems.services.AssureService;
import com.esocial.esocialsystems.services.EmployeurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/assures")
public class AssureServlet extends HttpServlet {
    private AssureService assureService;
    private EmployeurService employeurService;

    @Override
    public void init() throws ServletException {
        assureService = new AssureService();
        employeurService = new EmployeurService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeurIdStr = request.getParameter("employeurId");

        if (employeurIdStr != null && !employeurIdStr.isEmpty()) {
            int employeurId = Integer.parseInt(employeurIdStr);
            request.setAttribute("assures", assureService.listerParEmployeur(employeurId));
            request.setAttribute("employeur", employeurService.trouverParId(employeurId));
        }

        request.getRequestDispatcher("/views/assures.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        Double salaire = Double.parseDouble(request.getParameter("salaire"));
        int employeurId = Integer.parseInt(request.getParameter("employeurId"));

        try {
            assureService.creerAssure(nom, salaire, employeurId);
        } catch (Exception e) {
            request.setAttribute("erreur", e.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/assures?employeurId=" + employeurId);
    }
}