package com.esocial.esocialsystems.dao;

import com.esocial.esocialsystems.models.Employeur;
import jakarta.persistence.EntityManager;
import java.util.List;

public class EmployeurDao {
    public void create(Employeur employeur) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employeur);
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

    public List<Employeur> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Employeur e", Employeur.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Employeur findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Employeur.class, id);
        } finally {
            em.close();
        }
    }
}
