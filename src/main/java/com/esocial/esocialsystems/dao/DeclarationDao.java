package com.esocial.esocialsystems.dao;

import com.esocial.esocialsystems.models.Declaration;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DeclarationDao {

    public void create(Declaration declaration) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(declaration);
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

    public List<Declaration> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT d FROM Declaration d", Declaration.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Integer countByEmployeurAndMoisAndAnnee(int employeurId, int mois, int annee) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Long count = em.createQuery(
                                 "SELECT COUNT(d.id) FROM Declaration d " +
                                    "WHERE d.employeur.id = :empId AND d.mois = :mois AND d.annee = :annee", Long.class)
                    .setParameter("empId", employeurId)
                    .setParameter("mois", mois)
                    .setParameter("annee", annee)
                    .getSingleResult();

            return count.intValue();
        } finally {
            em.close();
        }
    }
}