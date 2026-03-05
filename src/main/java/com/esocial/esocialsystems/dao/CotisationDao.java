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
}