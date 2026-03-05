package com.esocial.esocialsystems.services;

import com.esocial.esocialsystems.dao.DeclarationDao;
import com.esocial.esocialsystems.dao.EmployeurDao;
import com.esocial.esocialsystems.models.Declaration;
import com.esocial.esocialsystems.models.Employeur;
import java.time.LocalDate;

public class DeclarationService {
    private DeclarationDao declarationDao = new DeclarationDao();
    private EmployeurDao employeurDao = new EmployeurDao();

    public boolean verifierUnicite(int employeurId, int mois, int annee) {
        int count = declarationDao.countByEmployeurAndMoisAndAnnee(employeurId, mois, annee);
        return count == 0;
    }

    public Declaration creerDeclaration(int employeurId, int mois, int annee) throws Exception {
        if (!verifierUnicite(employeurId, mois, annee)) {
            throw new Exception("Erreur : Cet employeur a déjà une déclaration pour cette période.");
        }

        Employeur employeur = employeurDao.findById(employeurId);
        if (employeur == null) {
            throw new Exception("Employeur introuvable.");
        }

        Declaration declaration = new Declaration();
        declaration.setEmployeur(employeur);
        declaration.setMois(mois);
        declaration.setAnnee(annee);
        declaration.setDateDeclaration(LocalDate.now());

        declarationDao.create(declaration);
        return declaration;
    }
}