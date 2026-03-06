package com.esocial.esocialsystems.servlets;

import com.esocial.esocialsystems.models.Declaration;
import com.esocial.esocialsystems.models.Employeur;
import com.esocial.esocialsystems.services.CotisationService;
import com.esocial.esocialsystems.services.DeclarationService;
import com.esocial.esocialsystems.services.EmployeurService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeclarationServlet", urlPatterns = {"/declarations"})
public class DeclarationServlet extends HttpServlet {

    private DeclarationService declarationService;
    private EmployeurService employeurService;
    private CotisationService cotisationService;

    @Override
    public void init() throws ServletException {
        declarationService = new DeclarationService();
        employeurService = new EmployeurService();
        cotisationService = new CotisationService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            List<Employeur> employeurs = employeurService.listerEmployeurs();
            request.setAttribute("employeurs", employeurs);
            request.getRequestDispatcher("/WEB-INF/views/declarations/create.jsp").forward(request, response);
        } else {
            List<Declaration> declarations = declarationService.consulterLesDeclarations();
            request.setAttribute("declarations", declarations);
            request.getRequestDispatcher("/WEB-INF/views/declarations/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int employeurId = Integer.parseInt(request.getParameter("employeurId"));
            int mois = Integer.parseInt(request.getParameter("mois"));
            int annee = Integer.parseInt(request.getParameter("annee"));

            Declaration declaration = declarationService.creerDeclaration(employeurId, mois, annee);

            cotisationService.calculerEtEnregistrer(declaration);

            response.sendRedirect(request.getContextPath() + "/declarations");

        } catch (Exception e) {
            request.setAttribute("erreur", e.getMessage());

            List<Employeur> employeurs = employeurService.listerEmployeurs();
            request.setAttribute("employeurs", employeurs);

            request.getRequestDispatcher("/WEB-INF/views/declarations/create.jsp").forward(request, response);
        }
    }
}