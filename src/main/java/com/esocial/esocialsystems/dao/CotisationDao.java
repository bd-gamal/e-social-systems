package com.esocial.esocialsystems.dao;

import com.esocial.esocialsystems.models.Cotisation;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CotisationDao {

    public void create(Cotisation cotisation) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cotisation);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Cotisation> findByDeclaration(int declarationId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cotisation c WHERE c.declaration.id = :decId", Cotisation.class)
                    .setParameter("decId", declarationId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public Double calculerTotalParEmployeur(int employeurId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Double total = em.createQuery(
                            "SELECT SUM(c.montantSalarial + c.montantPatronal) " +
                                    "FROM Cotisation c WHERE c.declaration.employeur.id = :empId", Double.class)
                    .setParameter("empId", employeurId)
                    .getSingleResult();

            if (total == null) {
                return 0.0;
            }
            return total;
        } finally {
            em.close();
        }
    }
}