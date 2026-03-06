package com.esocial.esocialsystems.services;

import com.esocial.esocialsystems.dao.AssureDao;
import com.esocial.esocialsystems.dao.CotisationDao;
import com.esocial.esocialsystems.models.Assure;
import com.esocial.esocialsystems.models.Cotisation;
import com.esocial.esocialsystems.models.Declaration;
import java.util.List;

public class CotisationService {
    private AssureDao assureDao = new AssureDao();
    private CotisationDao cotisationDao = new CotisationDao();

    private static final double TAUX_SALARIAL = 0.0448;
    private static final double TAUX_PATRONAL = 0.0898;
    private static final double PLAFOND_SALAIRE = 6000.0;

    public Double obtenirTotalCotisationsEmployeur(int employeurId) {
        return cotisationDao.calculerTotalParEmployeur(employeurId);
    }

    public void calculerEtEnregistrer(Declaration declaration) {
        List<Assure> assures = assureDao.findByEmployeur(declaration.getEmployeur().getId());

        for (Assure assure : assures) {
            double salaire = assure.getSalaireMensuel();
            double baseCalcul = Math.min(salaire, PLAFOND_SALAIRE);

            double montantSalarial = baseCalcul * TAUX_SALARIAL;
            double montantPatronal = baseCalcul * TAUX_PATRONAL;

            Cotisation cotisation = new Cotisation();
            cotisation.setAssure(assure);
            cotisation.setDeclaration(declaration);
            cotisation.setBaseCalcul(baseCalcul);
            cotisation.setMontantSalarial(montantSalarial);
            cotisation.setMontantPatronal(montantPatronal);

            cotisationDao.create(cotisation);
        }
    }
}