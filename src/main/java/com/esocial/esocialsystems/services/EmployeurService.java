package com.esocial.esocialsystems.services;

import com.esocial.esocialsystems.dao.EmployeurDao;
import com.esocial.esocialsystems.models.Employeur;
import java.util.List;

public class EmployeurService {
    private EmployeurDao employeurDao = new EmployeurDao();

    public void creerEmployeur(String raisonSociale, String secteurActivite) {
        Employeur employeur = new Employeur();
        employeur.setRaisonSociale(raisonSociale);
        employeur.setSecteurActivite(secteurActivite);
        employeurDao.create(employeur);
    }

    public List<Employeur> listerEmployeurs() {
        return employeurDao.findAll();
    }

    public Employeur trouverParId(int id) {
        return employeurDao.findById(id);
    }
}