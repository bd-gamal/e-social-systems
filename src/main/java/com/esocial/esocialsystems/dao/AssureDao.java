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

    public void update(Assure assure) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(assure);
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

    public Assure findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Assure.class, id);
        } finally {
            em.close();
        }
    }

    public List<Assure> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Assure a", Assure.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Assure> findByEmployeur(int employeurId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Assure a WHERE a.employeur.id = :empId", Assure.class)
                    .setParameter("empId", employeurId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public Object[] getDroitsAssure(int assureId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Object[] resultat = (Object[]) em.createQuery(
                            "SELECT COUNT(c.id), SUM(c.montantSalarial + c.montantPatronal) " +
                                    "FROM Cotisation c WHERE c.assure.id = :assureId")
                    .setParameter("assureId", assureId)
                    .getSingleResult();

            if (resultat[1] == null) {
                resultat[1] = 0.0;
            }

            return resultat;
        } finally {
            em.close();
        }
    }
}