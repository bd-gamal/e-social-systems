package com.esocial.esocialsystems.dao;

import com.esocial.esocialsystems.models.Assure;
import jakarta.persistence.EntityManager;
import java.util.List;

public class AssureDao {

    public void create(Assure assure) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(assure);
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

    public Assure findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Assure.class, id);
        } finally {
            em.close();
        }
    }

    public List<Assure> findByEmployeur(int employeurId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT a FROM assures a WHERE a.employeur.id = :empId", Assure.class)
                    .setParameter("empId", employeurId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public Object[] getDroitsAssure(int assureId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return (Object[]) em.createQuery(
                            "SELECT COUNT(c.id), COALESCE(SUM(c.montantSalarial + c.montantPatronal), 0) " +
                                    "FROM cotisations c WHERE c.assure.id = :assureId")
                    .setParameter("assureId", assureId)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }
}