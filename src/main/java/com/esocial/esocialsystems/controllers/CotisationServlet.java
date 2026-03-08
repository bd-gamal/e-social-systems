package com.esocial.esocialsystems.controllers;

import com.esocial.esocialsystems.models.Declaration;
import com.esocial.esocialsystems.services.CotisationService;
import com.esocial.esocialsystems.services.DeclarationService;
import com.esocial.esocialsystems.services.EmployeurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cotisations")
public class CotisationServlet extends HttpServlet {
    private CotisationService cotisationService;
    private DeclarationService declarationService;
    private EmployeurService employeurService;

    @Override
    public void init() throws ServletException {
        cotisationService = new CotisationService();
        declarationService = new DeclarationService();
        employeurService = new EmployeurService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employeurs", employeurService.listerEmployeurs());
        request.getRequestDispatcher("/WEB-INF/views/cotisations.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int employeurId = Integer.parseInt(request.getParameter("employeurId"));
            int mois = Integer.parseInt(request.getParameter("mois"));
            int annee = Integer.parseInt(request.getParameter("annee"));

            Declaration declaration = declarationService.creerDeclaration(employeurId, mois, annee);
            cotisationService.calculerEtEnregistrer(declaration);

            request.setAttribute("messageSuccess", "Déclaration validée et cotisations calculées avec succès !");
        } catch (Exception e) {
            request.setAttribute("messageErreur", e.getMessage());
        }

        doGet(request, response);
    }
}