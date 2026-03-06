package com.esocial.esocialsystems.services;

import com.esocial.esocialsystems.dao.AssureDao;
import com.esocial.esocialsystems.dao.EmployeurDao;
import com.esocial.esocialsystems.models.Assure;
import com.esocial.esocialsystems.models.Employeur;
import java.util.List;

public class AssureService {
    private AssureDao assureDao = new AssureDao();
    private EmployeurDao employeurDao = new EmployeurDao();

    public void creerAssure(String nom, Double salaire, int employeurId) throws Exception {
        Employeur employeur = employeurDao.findById(employeurId);
        if (employeur == null) {
            throw new Exception("Employeur introuvable.");
        }

        Assure assure = new Assure();
        assure.setNom(nom);
        assure.setSalaireMensuel(salaire);
        assure.setEmployeur(employeur);
        assureDao.create(assure);
    }

    public void modifierSalaire(int assureId, double nouveauSalaire) throws Exception {
        Assure assure = assureDao.findById(assureId);
        if (assure == null) {
            throw new Exception("Assuré introuvable.");
        }
        assure.setSalaireMensuel(nouveauSalaire);
        assureDao.update(assure);
    }

    public List<Assure> listerTous() {
        return assureDao.findAll();
    }

    public List<Assure> listerParEmployeur(int employeurId) {
        return assureDao.findByEmployeur(employeurId);
    }

    public Object[] consulterDroits(int assureId) {
        return assureDao.getDroitsAssure(assureId);
    }
}